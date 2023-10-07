package edu.ics211.h06;

import java.util.Arrays;

/*
 * OffsetArrayList<E>
 * 
 * @author Alessandra Gudoy
 * 
 * 
 * (Assume index parameter is a valid random number for a list of size n)
 * 	Runtimes:			[Best Case]		[Average Case]		[Worst Case]
 *  Add at index:			O(1)			O(n)				O(n)
 *  Add at end:				O(1)			O(n)				O(n)
 *  Remove at index:		O(1)			O(n)				O(n)
 * 
 * 
 * 
 * whenever arrays.copyOf(), O(n)
 */

@SuppressWarnings("unchecked")
public class OffsetArrayList<E> {
	
	protected E[] data;						// array of data
	protected int size;						// numer of elements inside array
	protected final int initialCapacity;	// initial capacity of array
	protected final int offset;				// offset of indeces
	
	public OffsetArrayList() {				// default constructor
		this.initialCapacity = 16;			// initial capacity is 16
		this.offset = 0;					// offset is 0

		data = (E[]) new Object[16];
		this.size = 0;
	}

	// constructor: sets initial capacity and offset
	// initial capacity must be at least 0
	public OffsetArrayList(int initialCapacity, int offset) {

		if(initialCapacity < 0){
			throw new NegativeArraySizeException("Initial Capacity must be at least 0");
		}else{
			initialCapacity = initialCapacity == 0 ? 1 : initialCapacity;
			this.initialCapacity = initialCapacity;
			this.offset = offset;

			data = (E[]) new Object[initialCapacity];
			this.size = 0;
		}

	}
	
	/**
	 * Return the number of elements put in the array
	 * @return size, the number of elements put in the array
	 */
	public int size() { return size; }
	

	/**
	 * Return the greatest number of elements that can be put in the array
	 * @return capacity, the length of the array holding the elements
	 */
	public int capacity() { return data.length; }
	
	/**
	 * Return the offset of the indeces
	 * @return offset, how much indeces are offset by
	 */
	public int offest() { return offset; }
	
	
	/**
	 * Return the element at given index
	 * @param index of element to return
	 * @return element at given index
	 */
	public E get(int index) {
		if(index < offset || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else {
			return data[index - offset];
		}
	}
	
	
	/**
	 * Sets current element at given index to new element and returns previous element
	 * @param index of element to change to new element
	 * @param element that replaces current element at given index
	 * @return previous element at given index
	 */
	public E set(int index, E element) {
		if(index < offset || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else {
			E tmp = data[index - offset];
			data[index - offset] = element;

			return tmp;
		}
	}
	
	
	/**
	 * Return true after adding element to the end of the array
	 * @param element to add to array
	 * @return true
	 */
	public boolean add(E element) {
		if(size >= capacity()){
			extendArray();
		}

		data[size] = element;
		size += 1;

		return true;
	}
	

	/**
	 * Adds E element at given index, extends array if there is not enough space
	 * @param index at which E element is to be inserted at
	 * @param element to add to array at given index
	 */
	public void add(int index, E element) {
		if(index < offset || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else{

			if(size >= capacity()){
				extendArray();
			}

			for(int i=size(); i>index-offset; i--){
				data[i] = data[i-1];
			}

			data[index-offset] = element;
			size += 1;
		}
	}
	
	
	public E remove(int index) {
		if(offset > index || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else{
			E tmp = data[index - offset];

			for(int i=index+offset; i<size; i++){
				data[i] = data[i+1];
			}

			size -= 1;

			return tmp;
		}
	}
	

	public void extendArray(){
		E[] tmp = (E[]) new Object[capacity() * 2];

		for(int i=0; i<size; i++){
			tmp[i] = data[i];
		}

		data = tmp;

	}
	

	@Override
	public String toString() {
		String separator = "";
      	String result = "";

      	for (int i = 0; i < size; i++) {
        	result = result + separator + data[i].toString();
        	separator = ",";
      	}

      	return result;
	}


	public boolean unitTest(){

		boolean test1 = false;

		boolean test2 = false;

		boolean test3 = false;


		return test1 && test2 && test3;
	}


	public void print(){
		System.out.println(Arrays.deepToString(data));
	}
	
}
