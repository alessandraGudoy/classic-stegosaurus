package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class BasicStatement extends Statement{
	
	public BasicStatement() { }
	
	public BasicStatement(String[] tokes) throws InvalidStatementException {
		if(isMethodCall(tokes) || isAssignment(tokes)) {
			this.tokens = tokes;
		} else {
			throw new InvalidStatementException();
		}
	}
	

	// Every basic statement is NOT a compound statement
	public boolean isCompound() {
		return false;
	}
	
	/**
	 * Check if given array of tokens create a method call
	 * Given array is a valid method call if:
	 * 		the first token is a Java identifier, the second token is "(",
	 * 		the second to last token is ")", and the last token is ";"
	 * 		
	 * @param toks, array of tokens
	 * @return whether or not if input is a valid method call
	 */
	protected boolean isMethodCall(String[] toks) {
		return isJavaIdentifier(toks[0]) && toks[1].equals("(") &&
				toks[toks.length-2].equals(")") && toks[toks.length-1].equals(";");
	}
	
	/**
	 * Check if given array of tokens is a valid assignment statement
	 * Given array is a valid assignment statement if:
	 * 		the first token is a Java identifier, the second token is "=",
	 * 		and the last toke is ";"
	 * 
	 * @param toks, array of tokens
	 * @return whether or not if input is a valid assignment statement
	 */
	protected boolean isAssignment(String[] toks) {
		return isJavaIdentifier(toks[0]) && toks[1].equals("=") && 
				toks[toks.length-1].equals(";");
	}

}
