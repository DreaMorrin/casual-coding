/*
 	Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
	put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

	Follow up:
	Could you do both operations in O(1) time complexity?
	
	Example:
	LRUCache cache = new LRUCache(2); // 2 means capacity

	cache.put(1, 1);
	cache.put(2, 2);
	cache.get(1);       // returns 1
	cache.put(3, 3);    // evicts key 2
	cache.get(2);       // returns -1 (not found)
	cache.put(4, 4);    // evicts key 1
	cache.get(1);       // returns -1 (not found)
	cache.get(3);       // returns 3
	cache.get(4);       // returns 4
 */

public class LRUCache {

	// since the requirement indicates that value of key is always positive, we
	// make 0 as if the slot is not used.
	private final int AVAILABLE = 0;
	private final int NOT_AVAILABLE = -1;
	private final int DEFAULT_CAPACITY = 1;
	private int capacity;
	private int[] keysTable;
	private int[] dataTable;

	private int[] timeStampTable;
	private int currentTimeStamp;

	public LRUCache(int capacity) {
		this.capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
		keysTable = new int[capacity];
		dataTable = new int[capacity];
		timeStampTable = new int[capacity];
	}

	public int get(int key) {
		for (int offset = 0; offset < capacity; offset++) {
			int hashedKey = (key + offset) % capacity;

			if (keysTable[hashedKey] == AVAILABLE) {
				return NOT_AVAILABLE;
			} else if (keysTable[hashedKey] == key) {

				timeStampTable[hashedKey] = (currentTimeStamp++);
				return dataTable[hashedKey];
			}
		}

		return NOT_AVAILABLE;
	}

	public void put(int key, int value) {

		for (int offset = 0; offset < capacity; offset++) {
			int hashedKey = (key + offset) % capacity;

			// update existing key if there is one, or add key value pair if
			// slot is available
			// the checking order should not be reversed
			if (keysTable[hashedKey] == key || keysTable[hashedKey] == AVAILABLE) {
				saveKeyValue(key, value, hashedKey);
				return;
			}
		}

		// check if table is full, if so, perform eviction, and add key value
		// pair
		saveKeyValue(key, value, eviction());
	}

	private void saveKeyValue(int key, int value, int hashedKey) {
		keysTable[hashedKey] = key;
		dataTable[hashedKey] = value;
		timeStampTable[hashedKey] = (currentTimeStamp++);
	}

	private int eviction() {
		int leastRecentUsedHashedKey = 0;
		int leaseRecentUsedTimeStamp = timeStampTable[leastRecentUsedHashedKey];

		for (int i = 0; i < timeStampTable.length; i++) {
			if (timeStampTable[i] < leaseRecentUsedTimeStamp) {
				leastRecentUsedHashedKey = i;
				leaseRecentUsedTimeStamp = timeStampTable[i];
			}
		}

		keysTable[leastRecentUsedHashedKey] = AVAILABLE; // make evicted slot
															// available

		return leastRecentUsedHashedKey;
	}
}
