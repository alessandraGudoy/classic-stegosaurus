package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public abstract class Statement implements StatementInterface{

	protected String[] tokens;
	
	public Statement() { }
	
	public abstract boolean isCompound();
	
	/**
	 * Returns the number of tokens in the statement
	 * 
	 * @return number of tokens
	 */
	public int numTokens() {
		return this.tokens.length;
	}
	
	/**
	 * Returns the token at given index
	 * 
	 * @param index of token to get
	 * @throws ArrayIndexOutOfBoundsException if given index is invalid
	 */
	public String getToken(int index) {
		if(index < 0 || index >= numTokens()){
			throw new ArrayIndexOutOfBoundsException();
		}

		return this.tokens[index];
	}
	
	/**
	 * Rebuilds and returns the statement from the tokens
	 * @return the statement the tokens build
	 */
	public String toString() {
		
		String output = "";
		
		for(int i=0; i<this.tokens.length; i++) {
			output += this.tokens[i] + " ";
		}
		
		
		return output.trim();
	}
	
	/**
	 * Checks if given statement is equal to this statement
	 * 
	 * @param object to compare this statement to
	 * @return whether or not both statements are equal
	 */
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
	
	/**
	 * Checks whether or not given string is a valid Java identifier
	 * The given string is a valid Java identifier if:
	 * 		the first character returns true for isJavaIdentifierStart()
	 * 		and every character after returns true for isJavaIdentifierPart()
	 * 
	 * @param str to check if is a valid Java identifier
	 * @return whether or not fiven string is a valid Java identifier
	 */
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
