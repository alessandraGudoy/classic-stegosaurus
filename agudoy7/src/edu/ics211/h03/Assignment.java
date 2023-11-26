package edu.ics211.h03;

import java.util.Objects;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class Assignment extends BasicStatement{
	
	public Assignment() { }
	
	public Assignment(String[] tokens) throws InvalidStatementException {
		
		super();
		
		Objects.requireNonNull(tokens);
		
		if(!isJavaIdentifier(tokens[0]) || !tokens[1].equals("=") || !tokens[tokens.length-1].equals(";")) {
			throw new InvalidStatementException();
		}
		
		this.tokens = tokens;
	}
	
	
	public String getVariable() {
		return this.tokens[0];
	}

}
