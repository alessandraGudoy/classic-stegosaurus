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
		//System.out.println(Arrays.deepToString(firstTernaryNumbers(31)));
		System.out.println(checkBase16(15));
		System.out.println(toBase16(15));
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
	
	
	public static String checkBase16(int n) {
		String temp = HexFormat.of().toHexDigits(n);
		int trimOff = 0;
		
		while(temp.charAt(trimOff) == '0') {
			++trimOff;
		}
		
		return temp.substring(trimOff);
	}
	
	
	public static String toBase16(int n) {
		if(n < 16) {
			return ("" + hexDigits[n]);
		} else {
			return toBase16( n / 16 ) + hexDigits[n%16];
		}
	}
	
	
	
}
