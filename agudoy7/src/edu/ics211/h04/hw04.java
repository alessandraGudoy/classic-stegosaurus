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
	 * Sorts array through Selection Sort algorithm
	 * Looping through array and selecting next smallest char to sort the array
	 * 
	 * @param a the array of characters to sort
	 */
	public static void selectionSort(char[] a) {
		
		for(int i=0; i<a.length; i++) {		// starting at an index
			
			for(int j=i; j<a.length; j++) {	// loop through the rest of array and find the smallest char
				
				if(a[j] < a[i]) { 			// if element is smaller than current element, swap the elements
					swap(a, i, j); 
				}
				
			}
			
		}
		
	}

	
	// TODO		// like selection sort, but only returns unique elements
	public static String selectUnique(char[] a) {
		// student must implement
		return new String(a); // this string is not sorted!
	}
	

	// TODO
	public static void bubbleSort(char[] a) {
		// student must implement
	}
	
	
	// TODO
	public static void insertionSort(char[] a) {
		// student must implement
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
		}
	}
}