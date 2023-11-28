package edu.ics211.h12;

import java.util.LinkedList;

/**
 * Implement a Hashtable (using separate chaining) from this skeleton.
 * You will need to determine what hash function to use, you can look at
 * "https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()" for a way to get an index
 * from any object in java.
 *
 * Email Benjynstrauss@gmail.com or bnstraus@hawaii.edu if you have questions
 * 
 * @author Alessandra Gudoy
 *
 * @param <K> Key of the hash table
 * @param <V> Values of the hash table
 */

@SuppressWarnings("unchecked")
public class UHM_Hashtable<K,V> {
	
        // required: your hash table must be an array of lists
        // required: your hash table must be called table
        // required: table must be a protected variable
	protected LinkedList<Pair<K,V>>[] table;

	private final int INITAL_CAPACITY;
	private final double LOAD_FACTOR;
	private int size = 0;
	
	public UHM_Hashtable() {
		INITAL_CAPACITY = 11;
		LOAD_FACTOR = 0.75;
		table = new LinkedList[INITAL_CAPACITY];
	}
	
	/**
	 * 
	 * @param initialCapacity initial size of array, must be greater than 0
	 * @throws RuntimeException if initial size given is less than or equal to 0
	 */
	public UHM_Hashtable(int initialCapacity) {
		if(initialCapacity <= 0){
			throw new RuntimeException("Initial capacity must be greater than 0");
		}

		INITAL_CAPACITY = initialCapacity;
		LOAD_FACTOR = 0.75;
		table = new LinkedList[INITAL_CAPACITY];
	}
	
	/**
	 * 
	 * @param loadFactorOnResize when the load factor exceeds this, resize
	 * @throws RuntimeException if not (0 < load factor <= 1)
	 */
	public UHM_Hashtable(double loadFactorOnResize) {
		// if(0.0 >= loadFactorOnResize || loadFactorOnResize > 1){
		// 	throw new RuntimeException("Load Factor must be between 0 and 1.....0 < load factor <= 1");
		// }

		INITAL_CAPACITY = 11;
		LOAD_FACTOR = loadFactorOnResize;
		table = new LinkedList[INITAL_CAPACITY];
	}
	
	/**
	 * 
	 * @param initialCapacity initial size of array	
	 * @param loadFactorOnResize when the load factor exceeds this, resize
	 * @throws RuntimeException if initialCapacity <= 0 or not (0 < load factor <= 1)
	 */
	public UHM_Hashtable(int initialCapacity, double loadFactorOnResize) {
		if(initialCapacity <= 0){
			throw new RuntimeException("Initial capacity must be greater than 0");
		}

		// if(0.0 >= loadFactorOnResize || loadFactorOnResize > 1){
		// 	throw new RuntimeException("Load Factor must be between 0 and 1.....0 < load factor <= 1");
		// }

		INITAL_CAPACITY = initialCapacity;
		LOAD_FACTOR = loadFactorOnResize;
		table = new LinkedList[INITAL_CAPACITY];
	}
	
	/**
	 * Adds a key-value pair into the hash table
	 * @param key of key-value pair to add
	 * @param value to add usive given key
	 * @throws NullPointerException if given key or value is null
	 */
	public void put(K key, V value) {	// TODO
		checkKey(key, value);

		int h = key.hashCode() % table.length;

		if(table[h] != null){
			for(Pair<K, V> pair : table[h]){
				if(pair.x.equals(key)){
					pair.y = value;
					return;
				}
			}
		}

		if(table[h] == null){
			table[h] = new LinkedList<>();
		}

		table[h].add(new Pair<K,V>(key, value));

		size = size + 1;

		if((double) size / table.length >= LOAD_FACTOR){
			rehash(table.length * 2 + 1);
		}
	}
	
	/**
	 * Get the value associated with given key
	 * @param key of value to return
	 * @return value of given key
	 */
	public V get(K key) {
		if(key == null){
			throw new NullPointerException();
		}
		int index = key.hashCode() % table.length;

		if(table[index] != null){
			for(Pair<K, V> pair : table[index]){
				if(pair.x.equals(key)){
					return pair.y;
				}
			}
		}

		return null;
	}
	
	/**
	 * Puts a key-value pair into the hash table
	 * 	If there is a value already at the given key, return the value. Else, return null
	 * @param key of key-value pair to add
	 * @param value to add using given key
	 * @return existing value at given key
	 * @throws NullPointerException if given key or value is null
	 */
	public V replace(K key, V value) {	// TODO
		checkKey(key, value);
		
		int h = key.hashCode() % table.length;

		if(table[h] != null){
			for(Pair<K, V> pair : table[h]){
				if(pair.x.equals(key)){
					V item = pair.y;
					pair.y = value;
					return item;
				}
			}
		}

		if(table[h] == null){
			table[h] = new LinkedList<>();
		}

		table[h].add(new Pair<K, V>(key, value));
		size = size + 1;

		if((double) size / table.length >= LOAD_FACTOR){
			rehash(table.length * 2 + 1);
		}

		return null;
	}
	
	/**
	 * Removes a key-value pair from the hash table and returns the value if key is found
	 * @param key, the key-value pair to remove
	 * @return value of the key to be removed
	 * @throws NullPointerException if key is null
	 */
	public V remove(K key) {

		if(key == null){
			throw new NullPointerException();
		}

		int index = key.hashCode() % table.length;

		if(table[index] == null){
			return null;
			// throw new RuntimeException("Key does not exist");
		}

		for(int i=0; i<table[index].size(); i++){
			if(table[index].get(i).x.equals(key)){
				V item = table[index].get(i).y;
				table[index].remove(i);
				size = size - 1;
				return item;
			}
		}

		return null;
		// throw new RuntimeException("Key does not exist");
	}
	
	/**
	 * 
	 * @return the number of elements in the hash table
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all elements from the hash table
	 */
	public void clear() {
		for(int i=0; i<table.length; i++){
			if(table[i] != null){
				table[i].clear();
			}
		}

		size = 0;
	}
	
	/**
	 * 
	 * @return load factor of hash table
	 */
	public double loadFactor() {
		return (double) size / table.length;
	}
	
	/**
	 * Rehashes the hash table and sets the size of the array given by input
	 * @param size the new size of the array
	 */
	public void rehash(int size) {		// TODO
		LinkedList<Pair<K, V>>[] copy = table;

		table = new LinkedList[size];

		for(int i=0; i<copy.length; i++){
			if(copy[i] != null){
				for(Pair<K, V> pair : copy[i]){
					int index = pair.x.hashCode() % table.length;
					
					if(table[index] == null){
						table[index] = new LinkedList<>();
					}

					table[index].add(pair);
				}
			}
		}

	}
	
	/**
	 * 
	 * @return the maximum length of any list
	 */
	public int maxListLen() {
		int max = 0;

		for(int i=0; i<table.length; i++){
			int size = 0;
			if(table[i] != null){
				size = table[i].size();
			}

			if(size >= max){
				max = size;
			}
		}

		return max;
	}

	public void p(){
		for(int i=0; i< table.length; i++){
            if(table[i]!=null){System.out.println(i + "-" + table[i].toString());}
        }
	}

	private void checkKey(K key, V value){
		if(key == null || value == null){
			throw new NullPointerException();
		}
	}
	
	/** Do Not Change - Used in grading */
	public int keysAtIndex(int index) { return table[index].size(); }
	
	/** Do Not Change - Used in grading */
	public int arrayLen() { return table.length; }
}