package edu.ics211.h04;

import java.io.FileNotFoundException;

/**
 * hw04, Selection Sort, Bubble Sort, and Insertion Sort
 * 
 * @author esb@hawaii.edu, 2023
 * @author Gudoy, Alessandra
 */

public class hw04 {

	enum SortType {
		SelectionSort, SelectUnique, BubbleSort, InsertionSort,
	};
	

	/**
	 * Swaps elements at given indices of given array of characters
	 * @param a the array of characters to swap elements in
	 * @param i1, i2 the indices of elements to be swapped
	 */
	public static void swap(char[] a, int i1, int i2) {
		char tmp = a[i1];
		
		a[i1] = a[i2];
		a[i2] = tmp;
	}
	

	/**
	 * Sorts array using Selection Sort algorithm
	 * Looping through array and selecting next smallest char in unsorted array
	 * and moving it to the sorted part of the array
	 * 
	 * @param a the array of characters to sort
	 */
	public static void selectionSort(char[] a) {
		
		for(int i=0; i<a.length-1; i++) {		// starting at an index
			int smallest = i;
			
			for(int j=i+1; j<a.length; j++) {	// loop through the rest of array and find the smallest char
				if(a[j] < a[smallest]) { 		// if element is smaller than current element, swap the elements
					smallest = j;
				}
			}
			
			swap(a, i, smallest);
		}
		
	}

	
	/**
	 * Returns a string of an array's unique character sorted out
	 * 
	 * @param a the array of characters to sort and create a String of its unique characters
	 * @return String that is sorted containing the unique characters in the array
	 */
	public static String selectUnique(char[] a) {
		selectionSort(a);						// sort array using implemented selectionSort(char[] a) method
		
		String result = "";
		
		for(int i=0; i<a.length; i++) {			// loop through array
			if(result.indexOf(a[i]) == -1) {	// if result does not contain element, add it to string
				result += a[i];
			}
		}
		
		return result;							// return result
	}
	

	/**
	 * Sorts array using Bubble Sort algorithm
	 * Looping though array and swapping adjacent elements to sort the array
	 * which sorts the array starting from the end to the beginning
	 * 
	 * @param a the array of characters to sort
	 */
	public static void bubbleSort(char[] a) {
		
		for(int i=0; i<a.length; i++) {			// starting at an index
			
			for(int j=1; j<a.length-i; j++) {	// starting at the front
				if(a[j] < a[j-1]) {				// if adjacent elements are out of order,
					swap(a, j, j-1);			// swap
				}
			}
			
		}
		
	}
	
	
	/**
	 * Sorts array using Insertion Sort algorithm
	 * Looping through array and inserting next element of unsorted part of the array 
	 * into the correct position of the sorted part of the array
	 * 
	 * @param a the array of characters to sort
	 */
	public static void insertionSort(char[] a) {
		
		for(int i=1; i<a.length; i++) {				// starting at an index
			
			for(int j=i-1; j>=0; j--) {				// working backwards (from current index),
				if(a[j] > a[j+1]) {					// insert element into appropriate index
					swap(a, j+1, j);
				}
			}
			
		}
	}
	

	public static String sortChars(String s, SortType sort) {
		char[] a = s.toCharArray();
		switch (sort) {
		case SelectionSort:
			selectionSort(a);
			break;
		case BubbleSort:
			bubbleSort(a);
			break;
		case InsertionSort:
			insertionSort(a);
			break;
		case SelectUnique:
			return selectUnique(a);
		}
		return new String(a);
	}
	

	public static void main(String[] a) {
		if ((a == null) || (a.length < 1)) {
			a = new String[1];
			a[0] = "the quick brown fox jumps over the lazy dog";
		}
		for (String s : a) {
			System.out.println("\'" + s + "\' selection sorts to \'" + sortChars(s, SortType.SelectionSort) + "\'");
			System.out.println("\'" + s + "\' bubble sorts to \'" + sortChars(s, SortType.BubbleSort) + "\'");
			System.out.println("\'" + s + "\' insertion sorts to \'" + sortChars(s, SortType.InsertionSort) + "\'");
			System.out.println("\'" + s + "\' has characters \'" + sortChars(s, SortType.SelectUnique) + "\'");
			System.out.println();
		}
	}
}