package edu.ics211.h05;

import java.util.Arrays;
import java.util.HexFormat;

/*
 * HW05, Recursion
 * 
 * @author Alessandra Gudoy
 */

public class HW05 {
	
	private static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

	
	public static void main(String[] args) {
		
		// Printing first 31 ternary numbers
		System.out.println("First 31 ternary numbers");
		System.out.println(Arrays.deepToString(firstTernaryNumbers(31)));
		
		// Printing 500th to 524th hexadecimal numbers
		System.out.println();
		System.out.println("Printing 500 to 524 in hexadecimal");
		String[] hexValues = firstHexNumbers(525);
		for(int i=500; i<525; i++) {
			System.out.print(hexValues[i] + " ");
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
	

	public static String[] firstTernaryNumbers(int n) {

		String[] result = new String[n];

		for (int i = 0; i < n; i++) {
			result[i] = intToString(i, 3);
		}

		return result;
	}
	
	
	public static String toBase16(int n) {
		
		if(n < 16) {
			return ("" + hexDigits[n]);
		} else {
			return toBase16( n / 16 ) + hexDigits[n%16];
		}
		
	}
	
	
	public static String[] firstHexNumbers(int n) {
		
		String[] result = new String[n];
		
		for(int i=0; i<n; i++) {
			result[i] = toBase16(i);
		}
		
		return result;
	}
	
	
	
}
