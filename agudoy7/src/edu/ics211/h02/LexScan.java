package edu.ics211.h02;

import java.util.Arrays;

public class LexScan {

	public static void main(String[] args) {
		
		System.out.println("Name: Alessandra Gudoy");
		
		boolean test = unitTest();
		
		System.out.println();
		
		if(test) {
			System.out.println("SUCCESS");
		} else {
			System.out.println("TEST FAILED");
		}
		
	}
	
	
	public static String[] lexicalScanner(String str) {
		String[] result = new String[str.length()];
		
		int numTokens = 0;
		
		boolean starter = Character.isJavaIdentifierStart(str.charAt(0));
		boolean startingDigit = Character.isDigit(str.charAt(0));
		
		String tmp = "";
		
		for(int i=0; i<str.length(); i++) {
			char current = str.charAt(i);
			
			if(starter) {
				
				if(Character.isJavaIdentifierPart(current)) {
					tmp += str.substring(i, i+1);
				} else {
					result[numTokens] = tmp;
					numTokens += 1;
					tmp = "";
				}
				
			} else if(startingDigit) {
				
			} else if(Character.isWhitespace(current)) {
				
			} else {
				
			}
		}
		
		
		System.out.println();
		System.out.println(" *** PRINTING *** ");
		System.out.println("STR: " + str);
		System.out.println("ARR: " + Arrays.copyOf(result, numTokens));
		
		return Arrays.copyOf(result, numTokens);
	}
	
	
	public static boolean unitTest() {
		
		boolean test1 = false;
		
		boolean test2 = false;
		
		boolean test3 = false;
		
		boolean test4 = false;
		
		return test1 && test2 && test3 && test4;
	}
	
}
