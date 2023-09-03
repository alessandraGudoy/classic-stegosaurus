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
					
					/*System.out.println();
					System.out.println(" *** BUILDING ***");
					System.out.println("CURRENT: " + current);
					System.out.println("tmp: " + tmp);*/
					
				} else {
					result[numTokens] = tmp;
					numTokens += 1;
					tmp = "";
					
					starter = i<=str.length()-1 ? Character.isJavaIdentifierStart(current) : starter;
					startingDigit = i<=str.length()-1 ? Character.isDigit(current) : startingDigit;
				}
				
			} else if(startingDigit) {
				
				if(Character.isDigit(current)) {
					
					tmp += str.substring(i, i+1);
					
				} else {
					result[numTokens] = tmp;
					numTokens += 1;
					tmp = "";
					
					starter = i<=str.length()-1 ? Character.isJavaIdentifierStart(current) : starter;
					startingDigit = i<=str.length()-1 ? Character.isDigit(current) : startingDigit;
				}
				
			} else if(Character.isWhitespace(current)) {
				
				starter = i<=str.length()-1 ? Character.isJavaIdentifierStart(current) : starter;
				startingDigit = i<=str.length()-1 ? Character.isDigit(current) : startingDigit;
				
			} else {
				
				result[numTokens] = str.substring(i, i+1);
				numTokens += 1;
				tmp = "";
				
			}
		}
		
		
		System.out.println();
		System.out.println(" *** PRINTING *** ");
		System.out.println("STR: " + str);
		System.out.println("ARR: " + Arrays.deepToString(Arrays.copyOf(result, numTokens)));
		
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
		
		return test1 && test2 && test3 && test4;
	}
	
}
