
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
			
			System.out.println("Find cc's value is " + table.search("cc"));;
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
	
	public static void main(String[] args) {
		testHashTable();
	}

}
