public class HashTable implements HashTableInterface {
	private int noOfElements;
	private DataItem[] hashArray;
	private int tableLength;
	private double loadFactor = 0.5;
	private DataItem deleted = new DataItem(-1, 0);

// precondition: initialSize is a positive int
	public HashTable(int initialSize) {
		tableLength = initialSize;
		hashArray = new DataItem[tableLength];
	}
	
	public HashTable() {
		tableLength = 4;
		hashArray = new DataItem[tableLength];
	}
 // static nested class
	private static class DataItem {
		private int key;
		private int value;
		public DataItem(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	private int hashFunc(int key){
		
		return key % tableLength;
	}
	@Override
	public void insert(int key, int val) {
		
		DataItem item = new DataItem(key, val);
		int hashVal = hashFunc(key);
		// find an empty or available (deleted) index
		while(hashArray[hashVal] != null && hashArray[hashVal] != deleted && hashArray[hashVal].key != key) {
		hashVal++;
		// wrap around
		hashVal = hashVal % tableLength;
		}
		
		if(hashArray[hashVal] != null && hashArray[hashVal] != deleted){
			hashArray[hashVal].value += val;
		}else{
			
			hashArray[hashVal] = item;	
		}
		noOfElements++;
		if((noOfElements / tableLength) >= loadFactor){
			rehash();
		}
		
		
	}
	@Override
	public int search(int key) {

		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null) {
			
			if(hashArray[hashVal].key == key){
			
				return hashArray[hashVal].value; // found
			}
			
			hashVal++;
			hashVal = hashVal % tableLength;
		}
		
		return -1; // cannot find
	}
	@Override
	public int delete(int key) {
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if(hashArray[hashVal].key == key){
				int value = hashArray[hashVal].value;
				hashArray[hashVal] = deleted;
				noOfElements--;
				return value;
			}
			hashVal++;
			hashVal = hashVal % tableLength;
		}
			
		return -1;
	}
	private void rehash(){
		
		int oldTableLength = tableLength;
		DataItem[] oldhashArray = hashArray;
		
		tableLength *=2; 
		hashArray = new DataItem[tableLength];
		System.out.println("Rehashing to: " + tableLength);
		
		for(int i = 0;  i < oldhashArray.length; i++){
			
			if(oldhashArray[i] != null && oldhashArray[i] != deleted){
				insert(oldhashArray[i].key, oldhashArray[i].value);
			}
		}
	}
}

