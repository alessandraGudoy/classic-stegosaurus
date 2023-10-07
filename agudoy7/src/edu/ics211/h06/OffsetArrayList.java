package edu.ics211.h06;

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
 * 	Best case for adding at an index is constant time, O(1), when the array is large enough and we are adding to the end of the array, 
 * 	therefore, there is no need to duplicate the array or shift elements around or when the array is empty. The worst case for adding at an index is 
 * 	linear time, O(n), when the array is not large enough and/or we are adding to the beginning of the array (so we have to shift the elements forward to
 * 	make room for the new element at the front). On average, it will be linear time when adding to the middle of th array.
 * 
 * 	Best case for adding at the end is constant time, O(1), when the array is large enough and we don't need to copy the array. Worst case is linear time, O(n),
 * 	when the array is not large enough and we do need to copy the array. On average, it will be less than O(n), but still more than constant time, but taking out
 * 	constants, it will be linear time, O(n).
 * 
 * 	Best case for removing an index is constant time, O(1), when we are removing at the end of the array and there is no need to shift the elements.
 * 	Worst case is when we are removing at the beginning of the array and have to shift all elements to the front. On average, it will be greater than constant
 * 	time, but less than O(n), but still be linear time when we are removing in the middle of the array.
 * 
 * 
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
			//initialCapacity = initialCapacity == 0 ? 1 : initialCapacity;
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
	
	
	/**
	 * Removes element at given index and returns the removed element
	 * @param index of element to remove
	 * @return the removed element at given index
	 */
	public E remove(int index) {
		if(index < offset || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else{
			E tmp = data[index - offset];

			for(int i=index-offset; i<size; i++){
				data[i] = data[i+1];
			}

			size -= 1;

			return tmp;
		}
	}
	

	public void extendArray(){
		E[] tmp = (E[]) new Object[capacity() * 2 + 1];

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
	
}
