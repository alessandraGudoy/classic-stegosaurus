package edu.ics211.h05;

/**
 * HW05, Recursion
 * 	Convert decimal numbers up to base-36
 * 	Get first n terms of ternary, hex, and fib3 sequences
 * 
 * @author Alessandra Gudoy
 * 
 * Runtime Analysis:
 * 			Runtime of intToString(): O(log(n))
 * 			Runtime of fib3(): 		  O(3^n)
 * 
 */

public class HW05 {
	
	private static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

	
	public static void main(String[] args) {
		/*
		// Printing first 31 ternary numbers
		System.out.println("Printing first 31 ternary numbers");
		System.out.println(Arrays.deepToString(firstTernaryNumbers(31)));
		
		// Printing 500th to 524th hexadecimal numbers
		System.out.println();
		System.out.println("Printing 500 to 524 in hexadecimal");
		String[] hexValues = firstHexNumbers(525);
		for(int i=500; i<525; i++) {
			System.out.print(hexValues[i] + " ");
		}
		
		// Printing first 12 fib3 numbers
		System.out.println(); System.out.println();
		System.out.println("Printing first 12 of fib3 numbers");
		System.out.println(Arrays.deepToString(firstFib3(12)));
		*/
		
		// for(int i=-10; i<4; ++i) {
		// 	System.out.println(i + " " + fib3(i));
		// }
		// System.out.println(fib3(4));
		// System.out.println(fib3(10));
		System.out.println(convert(15,16));
		System.out.println(convert(35,36));
	}
	
	
	/**
	 * Converts the given integer in base-10 to the base given and returns the conversion
	 * 
	 * @param n integer to be converted
	 * @param base the base to convert n to, where base>1
	 * @return String representing converted int n in given base
	 */
	public static String convert(int n, int base) {
		
		if(n < base) {											// base case
			return ("" + hexDigits[n]);
		} else {
			return convert(n/base, base) + hexDigits[n%base];
		}
	}

	
	// only for base-2 to base-9
	public static String intToString(int toPrint, int base) {
		
		if (toPrint < base) {
			return ("" + toPrint);
		} else {
			return intToString(toPrint / base, base) + (toPrint % base);
		}
		
	}
	
	
	/**
	 * Creates and returns an array of strings representing the first n ternary numbers
	 * 
	 * @param n = first n terms to print
	 * @return array of Strings representing the first n ternary numbers
	 */
	public static String[] firstTernaryNumbers(int n) {

		String[] result = new String[n];

		for (int i = 0; i < n; i++) {
			result[i] = intToString(i, 3);
		}

		return result;
	}
	
	
	/**
	 * Converts the given integer in base-10 to the base-16
	 * Modified intToString() code
	 * 
	 * @param n integer to be converted
	 * @return String representing the converted int n in base-16
	 */
	public static String toBase16(int n) {
		
		if(n < 16) {
			return ("" + hexDigits[n]);
		} else {
			return toBase16(n / 16) + hexDigits[n%16];
		}
		
	}
	
	
	/**
	 * Creates and returns an array of strings representing the first n hexadecimal numbers
	 * 
	 * @param n = first n terms to print
	 * @return array of Strings representing the first n hexadecimal numbers
	 */
	public static String[] firstHexNumbers(int n) {
		
		String[] result = new String[n];
		
		for(int i=0; i<n; i++) {
			result[i] = toBase16(i);
		}
		
		return result;
	}
	
	
	/**
	 * Calculates and returns the nth fib3 number where it is the sum of the previous three terms
	 * fib(n) = fib(n-1) + fib(n-2) + fib(n-3)
	 * 
	 * @param n = nth term to calculate
	 * @return int representing the nth term of fib3 sequence
	 */
	public static int fib3(int n) {
		if(n < 3) {
			return 1;
		} else {
			return fib3(n-1) + fib3(n-2) + fib3(n-3);
		}
	}
	
	
	/**
	 * Creates and returns an array of strings representing the first n fib3 numbers
	 * 
	 * @param n = first n terms to print
	 * @return array of Strings representing the first n fib3 numbers
	 */
	public static String[] firstFib3(int n) {
		
		String[] result = new String[n];
		
		for(int i=0; i<n; i++) {
			result[i] = String.valueOf(fib3(i));
		}
		
		return result;
	}
	
	
	
}
