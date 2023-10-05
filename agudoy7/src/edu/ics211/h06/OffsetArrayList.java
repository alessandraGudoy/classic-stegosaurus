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
	
	protected E[] data;
	protected int size;
	protected final int initialCapacity;
	protected final int offset;
	
	public OffsetArrayList() {
		this.initialCapacity = 16;
		this.offset = 0;

		data = (E[]) new Object[16];
		this.size = 0;
	}

	public OffsetArrayList(int initialCapacity, int offset) {

		if(initialCapacity < 0){
			throw new NegativeArraySizeException("Initial Capacity must be at least 0");
		}else{
			this.initialCapacity = initialCapacity;
			this.offset = offset;

			data = (E[]) new Object[initialCapacity];
			this.size = 0;
		}

	}
	
	
	public int size() { return size; }
	
	
	public int capacity() { return data.length; }
	
	
	public int offest() { return offset; }
	
	
	public E get(int index) {
		if(offset < index || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else {
			return data[index + offset];
		}
	}
	
	
	public E set(int index, E element) {
		if(offset < index || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else {
			E tmp = data[index + offset];
			data[index + offset] = element;

			return tmp;
		}
	}
	
	
	public boolean add(E element) {
		if(size >= capacity()){
			extendArray();
		}

		//size += 1;
		//data[size] = element;
		

		return true;
	}
	
	
	public void add(int index, E element) {
		if(offset < index || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else{
			size += 1;

			if(size > capacity()){
				extendArray();
			}

			for(int i=size; i>index+offset; i--){
				data[i] = data[i-1];
			}

			data[index+offset] = element;
		}
	}
	
	
	public E remove(int index) {
		if(offset < index || index >= size() + offset){
			throw new IndexOutOfBoundsException("INDEX OUT OF BOUNDS");
		} else{
			E tmp = data[index + offset];

			for(int i=index+offset; i<size; i++){
				data[i] = data[i+1];
			}

			size -= 1;

			return tmp;
		}
	}
	

	public void extendArray(){
		System.out.println("EXTENDING ARRAY");
		E[] tmp = (E[]) new Object[capacity() * 2];
		System.out.println(tmp.length);
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
		Arrays.deepToString(data);
	}
	
}
