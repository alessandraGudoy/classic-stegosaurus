package edu.ics211.practice;

/**
 * This assignment will be exploring heaps and heap-sort,
 *  and introducing you to O(nâ€¢lg(n)) sorting algorithms
 * 
 * Instructions:
 * Fill in the methods marked TODO
 * You may not use any classes from java.util, except for classes that extend Throwable
 * 		(this includes all errors and exceptions)
 * 
 * Wikipedia is a great resource for this assignment:
 * 		https://en.wikipedia.org/wiki/Heap_(data_structure)
 * 
 * @author Benjamin Strauss and [your name here]
 *
 */

public class MinHeap<E extends Comparable<E>> {
	
	public Object elements[];
	//TODO additional variables go here
	
	public MinHeap() {
		//TODO Initialize array with a default initial capacity
	}
	
	public MinHeap(int initialCapacity) {
		//TODO Initialize array with parameter
	}
	
	public MinHeap(E[] array) {
		//TODO place objects from 'array' into 'elements' so as to construct a min heap
	}
	
	public void insert(E element) {
		//TODO insert "element" into the heap
	}
	
	/**
	 * 
	 * @return heap's minimum element
	 */
	public E findMin() {
		//TODO find and return minimum element
		return null;
	}
	
	/**
	 * 
	 * @return heap's minimum element
	 */
	public E removeMin() {
		//TODO return and remove minimum element
		//should run in O(log(n) time)
		return null;
	}
	
	/**
	 * 
	 * @return how many elements are in the heap
	 */
	public int size() {
		//TODO return # of elements in the heap
		return 0;
	}
	
	public boolean empty() {
		//TODO return true if size == 0
		return false;
	}
	
	public void clear() {
		//TODO remove all elements from the heap
	}
	
	/**
	 * Resizes the heap, editable
	 */
	public void resizeHeap() { resizeHeap(elements.length*2+1); }
	
	/**
	 * Resizes the heap, editable
	 * @param size: new size of the heap 
	 */
	public void resizeHeap(int size) {
		Object[] temp = elements;
		elements = new Object[size];
		System.arraycopy(temp, 0, elements, 0, elements.length);
	}
}