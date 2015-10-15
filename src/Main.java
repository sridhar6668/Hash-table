
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable table = new HashTable();
		table.insert(10, 1);
		table.insert(10, 1);
		table.insert(10, 1);
		table.insert(10, 1);
		table.insert(10, 1);
		System.out.println("Search result: key - " + 10 +" value - " +table.search(10));
		
		for(int i = 0; i < 100; i++){
			table.insert(i, 1);
		}
		System.out.println("Search result: key - " + 10 +" value - " +table.search(10));
		table.delete(10);
		System.out.println("Search result: key - " + 10 +" value - " +table.search(10));
		return;
	}

}
