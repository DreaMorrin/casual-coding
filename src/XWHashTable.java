
public class XWHashTable extends Exception {

	private static final long serialVersionUID = 1L;
	private int size;
	private int[] dataTable;
	private int[] keyTable;

	public XWHashTable(int size) {
		this.size = size;
		dataTable = new int[size];
		keyTable = new int[size];
	}

	private int convertToInt(String key) {
		int n = key.length();
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += (key.charAt(i) * i);
		}
		return sum;
	}

	public void insert(String key, int value) throws Exception {

		if (value == 0) {
			throw new Exception("0 can not be stored as value");
		}

		int originalKey = convertToInt(key);

		// linear probing
		for (int i = 0; i < size; i++) {
			int idx = (originalKey + i) % size;

			if (dataTable[idx] == 0) {
				dataTable[idx] = value;
				keyTable[idx] = originalKey;
				return;
			}
		}
		throw new Exception("HashTable is full");
	}

	public Integer search(String key) {
		int originalKey = convertToInt(key);

		// linear probing
		for (int i = 0; i < size; i++) {
			int idx = (originalKey + i) % size;

			if (keyTable[idx] == originalKey) {
				return (dataTable[idx] == 0 ? null : dataTable[idx]);
			}
		}
		return null;
	}

	public void delete(String key) {
		int originalKey = convertToInt(key);

		// linear probing
		for (int i = 0; i < size; i++) {
			int idx = (originalKey + i) % size;

			if (keyTable[idx] == originalKey) {
				dataTable[idx] = 0;
				keyTable[idx] = 0;
			}
		}
	}
}
