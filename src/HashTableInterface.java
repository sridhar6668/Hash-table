/*
* HashTable interface that takes only positive int values
*/
public interface HashTableInterface {
/**
* Inserts a new int key to the table
* @param key int key to be inserted
*/
void insert(int key, int val);
/**
* Returns true when the key is found
* @param key int key value to be searched
* @return boolean value true if found, false not found
*/
int search(int key);
/**
* Deletes and returns an int value from the table
* @param key int value to be deleted
* @return the deleted int value
*/
int delete(int key);
}