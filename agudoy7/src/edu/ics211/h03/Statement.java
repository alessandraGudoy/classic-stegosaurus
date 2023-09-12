package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public abstract class Statement implements StatementInterface{

	protected String[] tokens;
	
	public Statement() {}
	
	
	public abstract boolean isCompound();
	
	
	public int numTokens() {
		return this.tokens.length;
	}
	
	
	public String getToken(int index) {
		return this.tokens[index];
	}
	
	
	public String toString() {
		
		String output = "";
		
		for(int i=0; i<this.tokens.length; i++) {
			output += this.tokens[i] + " ";
		}
		
		
		return output.trim();
	}
	
	
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Statement)) {
			return false;
		} else {
			Statement st = (Statement) obj;
			
			if(st.tokens.length == this.tokens.length) {
				
				for(int i=0; i<this.tokens.length; i++) {
					if(!st.tokens[i].equals(this.tokens[i])) {
						return false;
					}
				}
				
			} else {
				return false;
			}
			
			return true;
		}
	}
	
	
	protected static final boolean isJavaIdentifier(String str) {
		
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
