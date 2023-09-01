package edu.ics211.h01;

/**
 * Roots, calculates the roots between 2 and an integer.
 * @author Gudoy, Alessandra
 */

public class Roots {
	
	/**
	 * Calculates each root between 2 and an integer
	 * @param num, the last integer to find the root of, must be an integer greater than 2
	 * @return an array of doubles representing the roots between 2 and given integer
	 * @throws IllegalArgumentException if integer is less than 2
	 */
	public static double[] roots(int num) {
		
		// create an array where elements is each root calculated
		if(num >= 2) {
			double[] arr = new double[num - 1];
			
			for(int i = 2; i <= num; i++) {
				arr[i-2] = Math.sqrt(i);
			}
			
			return arr;
		}
		
		else {
			throw new IllegalArgumentException();
		}
		
	}
}
