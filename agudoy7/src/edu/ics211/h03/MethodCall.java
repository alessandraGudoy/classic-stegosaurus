package edu.ics211.h03;

import java.util.Objects;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class MethodCall extends BasicStatement{
	
	public MethodCall() {}

	public MethodCall(String[] tokens) throws InvalidStatementException {
		Objects.requireNonNull(tokens);
		
		if(!isJavaIdentifier(tokens[0]) || !tokens[1].equals("(") ||
				!tokens[tokens.length-2].equals(")") || !tokens[tokens.length-1].equals(";")) {
			
			throw new InvalidStatementException();
		}
		
		this.tokens = tokens;
	}
	
	
	public String getMethodName() {
		return this.tokens[0];
	}
	
}
