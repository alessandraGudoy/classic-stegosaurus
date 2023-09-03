package edu.ics211.h02;

import java.util.Arrays;

/**
 * LexScan, separates string into tokens
 * @author Gudoy, Alessandra
 */

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
	
	/**
	 * Returns a string of tokens given a string input
	 * A sequence of characters is considered a token when:
	 * CASE 1: the first character of a sequence returns true for isJavaIdentifierStart, 
	 * 		and following characters return true for isJavaIdentifierPart
	 * CASE 2: a substring is a sequence of characters that return true for isDigit()
	 * CASE 3: any substring of length 1 for which isWhiteSpace returns false
	 * 
	 * @param str, string to be separated into tokens
	 * @return an array of Strings where each element is a token
	 */
	public static String[] lexicalScanner(String str) {
		
		str.trim();
		
		String[] result = new String[str.length()];
		
		int numTokens = 0;
		
		boolean starter = Character.isJavaIdentifierStart(str.charAt(0));
		boolean startingDigit = Character.isDigit(str.charAt(0));
		
		String tmp = "";
		
		for(int i=0; i<str.length(); i++) {
			char current = str.charAt(i);
			
			if(starter) {
				
				if(Character.isJavaIdentifierPart(current)) {	// CASE 1: if isJavaIdentifierPart(), build token

					tmp += str.substring(i, i+1);
					
				} else if (Character.isWhitespace(current)){	// if isWhiteSpace(), add built token to array
																// and update values of starter and startingDigit using next char
					result[numTokens] = tmp;
					numTokens += 1;
					tmp = "";
					
					starter = Character.isJavaIdentifierStart(str.charAt(i+1));
					startingDigit = Character.isDigit(str.charAt(i+1));
					
				} else if(!Character.isWhitespace(current)) {	// if NOT isWhitespace(), add built token to array
																// add second token (CASE 3) and update starter and startingDigit
					result[numTokens] = tmp;
					numTokens += 1;
					result[numTokens] = str.substring(i, i+1);
					numTokens += 1;
					tmp = "";
					
					starter = i<str.length()-1 ? Character.isJavaIdentifierStart(str.charAt(i+1)) : starter;
					startingDigit = i<str.length()-1 ? Character.isDigit(str.charAt(i+1)) : startingDigit;
					
				} 
				
			} else if(startingDigit) {
				
				if(Character.isDigit(current)) {				// CASE 2: if isDigit(), build token
					
					tmp += str.substring(i, i+1);
					
				} else if(Character.isWhitespace(current)){		// if isWhiteSpace(), add built token to array
																// and update values of starter and startingDigit using next char
					result[numTokens] = tmp;
					numTokens += 1;
					tmp = "";
					
					starter = i<str.length()-1 ? Character.isJavaIdentifierStart(str.charAt(i+1)) : starter;
					startingDigit = i<str.length()-1 ? Character.isDigit(str.charAt(i+1)) : startingDigit;
					
				} else if(Character.isJavaIdentifierStart(current)) {	// CASE 1: if isJavaIdentifierStart(), build token
					
					result[numTokens] = tmp;
					numTokens += 1;
					tmp = str.substring(i, i+1);
					
					starter = Character.isJavaIdentifierStart(current);
					startingDigit = Character.isDigit(current);
					
				} else {										// if NOT isWhiteSpace(), add built token to array
																// add second token (CASE 3) and update starter and startingDigit
					result[numTokens] = tmp;
					numTokens += 1;
					result[numTokens] = str.substring(i, i+1);
					numTokens += 1;
					tmp = "";
					
					starter = i<str.length()-1 ? Character.isJavaIdentifierStart(str.charAt(i+1)) : starter;
					startingDigit = i<str.length()-1 ? Character.isDigit(str.charAt(i+1)) : startingDigit;
					
				}
				
			} else if(Character.isWhitespace(current)) {	// update starter and startingDigit using next char
				
				starter = i<str.length()-1 ? Character.isJavaIdentifierStart(str.charAt(i+1)) : starter;
				startingDigit = i<str.length()-1 ? Character.isDigit(str.charAt(i+1)) : startingDigit;
				
			} else {										// CASE 3: add token to array and update starter and startingDigit
				
				result[numTokens] = str.substring(i, i+1);
				numTokens += 1;
				tmp = "";
				
				starter = i<str.length()-1 ? Character.isJavaIdentifierStart(str.charAt(i+1)) : starter;
				startingDigit = i<str.length()-1 ? Character.isDigit(str.charAt(i+1)) : startingDigit;
				
			}
			
			// if loop ends without appending last token
			if(i==str.length()-1 && !tmp.equals("")) {
				
				result[numTokens] = tmp;
				numTokens += 1;
				tmp = "";
				
			}
		}
		
//		System.out.println(" *** PRINTING *** ");
//		System.out.println("STR: " + str);
//		System.out.println("ARR: " + Arrays.deepToString(Arrays.copyOf(result, numTokens)));
		
		return Arrays.copyOf(result, numTokens);
	}
	
	
	public static boolean unitTest() {
		
		boolean test1 = Arrays.equals(lexicalScanner("a2 = a1 + b22;"), 
				new String[] { "a2", "=", "a1", "+", "b22", ";"});
		
		boolean test2 = Arrays.equals(lexicalScanner("if (a++ < 2)"), 
				new String[] { "if", "(", "a", "+", "+", "<", "2", ")" });
		
		boolean test3 = Arrays.equals(lexicalScanner("a b c d e f g h i j k l m n o p q r s t u v w x y z"), 
				new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
						"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"});;
		
		boolean test4 = Arrays.equals(lexicalScanner("a18 19b 2c0 d2e f21"), 
				new String[] { "a18", "19", "b", "2", "c0", "d2e", "f21" });;
				
		boolean test5 = Arrays.equals(lexicalScanner("<>a, >ad32, 324 < a"), 
				new String[] {"<", ">", "a", ",", ">", "ad32", ",", "324", "<", "a"});
		
		return test1 && test2 && test3 && test4 && test5;
	}
	
}
