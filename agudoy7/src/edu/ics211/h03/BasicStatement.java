package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class BasicStatement extends Statement{
	
	public BasicStatement() { super(); }
	
	public BasicStatement(String[] tokes) throws InvalidStatementException {
		if(isMethodCall(tokes) || isAssignment(tokes)) {
			this.tokens = tokes;
		} else {
			throw new InvalidStatementException();
		}
	}
	

	public boolean isCompound() {
		return false;
	}
	
	
	protected boolean isMethodCall(String[] toks) {
		return isJavaIdentifier(toks[0]) && toks[1].equals("(") ||
				toks[toks.length-2].equals(")") && toks[toks.length-1].equals(";");
	}
	
	protected boolean isAssignment(String[] toks) {
		return isJavaIdentifier(toks[0]) && toks[1].equals("=") && toks[toks.length-1].equals(";");
	}

}
