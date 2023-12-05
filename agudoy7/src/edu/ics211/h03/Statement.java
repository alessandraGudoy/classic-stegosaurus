package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public abstract class Statement implements StatementInterface{

	protected String[] tokens;
	
public Statement() { /*System.out.println("super()");*/ }

    public Statement(String[] tokes) throws InvalidStatementException {
        if(isAssignment(tokes) || isMethodCall(tokes) || isWhileLoop(tokes) || isConditional(tokes)){
            this.tokens = tokes;
        } else{
            throw new InvalidStatementException();
        }
    }
	
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

    protected boolean isConditional(String[] toks) {
		boolean elseFound = false;
		
		for(int i=2; i<tokens.length-1; i++) {
			if(tokens[i].equals("else")) {
				elseFound = true;
			}
		}
		
		return tokens[0].equals("if") && tokens[1].equals("(") && 
				tokens[tokens.length-1].equals("}") && elseFound;
	}
	
	protected boolean isWhileLoop(String[] toks) {
		return tokens[0].equals("while") && tokens[1].equals("(");
	}
	
}
