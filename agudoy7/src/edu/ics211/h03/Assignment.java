package edu.ics211.h03;

import java.util.Objects;

public class Assignment extends BasicStatement{
	
	public Assignment(String[] tokens) {
		
		Objects.requireNonNull(tokens);
		
		if(!isJavaIdentifier(tokens[0]) || !tokens[1].equals("=") || !tokens[tokens.length-1].equals(";")) {
			throw new RuntimeException();
		}
		
		this.tokens = tokens;
	}
	
	
	public String getVariable() {
		
		
		
		return null;
	}

}
