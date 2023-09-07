package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public abstract class Statement implements StatementInterface{

	protected String[] tokens;
	
	public abstract boolean isCompound();
	
	
	public int numTokens() {
		return this.tokens.length;
	}
	
	
	public String getToken(int index) {
		return this.tokens[index];
	}
	
	
	public static final boolean isJavaIdentifier(String str) {
		
		if(!Character.isJavaIdentifierStart(str.charAt(0))) {
			return false;
		}
		
		for(int i=1; i<str.length(); i++) {
			if(!Character.isJavaIdentifierPart(str.charAt(i))) {
				return false;
			}
		}
		
		return true;
	}
	
}