
public class ZZZ {

	static void testHashTable() {
		XWHashTable table = new XWHashTable(5);

		try {
			System.out.println("Insert pairs of (aa, 1), (bb, 2), (cc, 3), (dd, 4), (ee, 5)");
			table.insert("aa", 1);
			table.insert("bb", 2);
			table.insert("cc", 3);
			table.insert("dd", 4);
			table.insert("ee", 5);

			System.out.println("Find cc's value is " + table.search("cc"));
			;
			System.out.println("Find ff's value is " + table.search("ff"));

			System.out.println("Delete cc pair");
			table.delete("cc");
			System.out.println("Find cc's value is " + table.search("cc"));

			System.out.println("Insert pair of (gg, 7), hash table should be full!");
			table.insert("gg", 7);

			System.out.println("Insert pair of (hh, 8), it should throw exception!");
			table.insert("hh", 8);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void testLRUCache() {
		// test case 1
		/*
		 * LRUCache cache = new LRUCache(2); cache.put(2, 1); cache.put(2, 2);
		 * System.out.println(cache.get(1)); // returns -1 (not found)
		 * cache.put(3, 3); System.out.println(cache.get(2)); // returns 2
		 * cache.put(4, 4); // evicts key 3 System.out.println(cache.get(1)); //
		 * returns -1 (not found) System.out.println(cache.get(3)); // returns
		 * -1 System.out.println(cache.get(4)); // returns 4
		 */

		// test case 2
		/*
		 * LRUCache cache = new LRUCache(2); cache.put(2, 1); cache.put(2, 2);
		 * System.out.println(cache.get(2)); // returns 2 cache.put(1, 1);
		 * cache.put(4, 1); // evicts key 2 System.out.println(cache.get(2)); //
		 * returns -1 (not found)
		 */

		// test case 3
		/*
		 * LRUCache cache = new LRUCache(2); System.out.println(cache.get(2));
		 * // returns -1 cache.put(2, 6); System.out.println(cache.get(1)); //
		 * returns -1 cache.put(1, 5); cache.put(1, 2);
		 * System.out.println(cache.get(1)); // returns 2
		 * System.out.println(cache.get(2)); // returns 6
		 */

		// test case 4
		/*
		 * LRUCache cache = new LRUCache(3); cache.put(1, 1); cache.put(2, 2);
		 * cache.put(3, 3); cache.put(4, 4); // evicts 1
		 * System.out.println(cache.get(4)); // returns 4
		 * System.out.println(cache.get(3)); // returns 3
		 * System.out.println(cache.get(2)); // returns 2
		 * System.out.println(cache.get(1)); // returns -1 cache.put(5, 5); //
		 * evicts 4 System.out.println(cache.get(1)); // returns -1
		 * System.out.println(cache.get(2)); // returns 2
		 * System.out.println(cache.get(3)); // returns 3
		 * System.out.println(cache.get(4)); // returns -1
		 * System.out.println(cache.get(5)); // returns 5
		 */

		// test case 5
		LRUCache cache = new LRUCache(10);
		cache.put(10, 13);
		cache.put(3, 17);
		cache.put(6, 11);
		cache.put(10, 5);
		cache.put(9, 10);
		System.out.println(cache.get(13));
		cache.put(2, 19);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(5, 25);
		System.out.println(cache.get(8));
		cache.put(9, 22);
		cache.put(5, 5);
		cache.put(1, 30);
		System.out.println(cache.get(11));
		cache.put(9, 12);
		System.out.println(cache.get(7));
		System.out.println(cache.get(5));
		System.out.println(cache.get(8));
		System.out.println(cache.get(9));
		cache.put(4, 30);
		cache.put(9, 3);
		System.out.println(cache.get(9));
		System.out.println(cache.get(10));
		System.out.println(cache.get(10));
		cache.put(6, 14);
		cache.put(3, 1);
		System.out.println(cache.get(3));
		cache.put(10, 11);
		System.out.println(cache.get(8));
		cache.put(2, 14);
		System.out.println(cache.get(1));
		System.out.println(cache.get(5));
		System.out.println(cache.get(4));
		cache.put(11, 4);
		cache.put(12, 24);
		cache.put(5, 18);
		System.out.println(cache.get(13));
		cache.put(7, 23);
		System.out.println(cache.get(8));
		System.out.println(cache.get(12));
		cache.put(3, 27);
		cache.put(2, 12);
		System.out.println(cache.get(5));
		cache.put(2, 9);
		cache.put(13, 4);
		cache.put(8, 18);
		cache.put(1, 7);
		System.out.println(cache.get(6));
		cache.put(9, 29);
		cache.put(8, 21);
		System.out.println(cache.get(5));
		cache.put(6, 30);
		cache.put(1, 12);
		System.out.println(cache.get(10));
		cache.put(4, 15);
		cache.put(7, 22);
		cache.put(11, 26);
		cache.put(8, 17);
		cache.put(9, 29);
		System.out.println(cache.get(5));
		cache.put(3, 4);
		cache.put(11, 30);
		System.out.println(cache.get(12));
		cache.put(4, 29);
		System.out.println(cache.get(3));
		System.out.println(cache.get(9));
		System.out.println(cache.get(6));
		cache.put(3, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(10));
		cache.put(3, 29);
		cache.put(10, 28);
		cache.put(1, 20);
		cache.put(11, 13);
		System.out.println(cache.get(3));
		cache.put(3, 12);
		cache.put(3, 8);
		cache.put(10, 9);
		cache.put(3, 26);
		System.out.println(cache.get(8));
		System.out.println(cache.get(7));
		System.out.println(cache.get(5));
		cache.put(13, 17);
		cache.put(2, 27);
		cache.put(11, 15);
		System.out.println(cache.get(12));
		cache.put(9, 19);
		cache.put(2, 15);
		cache.put(3, 16);
		System.out.println(cache.get(1));
		cache.put(12, 17);
		cache.put(9, 1);
		cache.put(6, 19);
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
		System.out.println(cache.get(5));
		cache.put(8, 1);
		cache.put(11, 7);
		cache.put(5, 2);
		cache.put(9, 28);
		System.out.println(cache.get(1));
		cache.put(2, 2);
		cache.put(7, 4);
		cache.put(4, 22);
		cache.put(7, 24);
		cache.put(9, 26);
		cache.put(13, 28);
		cache.put(11, 26);
	}

	public static void main(String[] args) {
		// testHashTable();
		testLRUCache();
	}

}
