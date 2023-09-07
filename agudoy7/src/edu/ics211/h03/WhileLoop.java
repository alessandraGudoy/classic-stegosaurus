package edu.ics211.h03;

import java.util.Objects;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class WhileLoop extends CompoundStatement{

	public WhileLoop(String[] tokens) {
		Objects.requireNonNull(tokens);
		
		if(!tokens[0].equals("while") || !tokens[1].equals("(")) {
			throw new RuntimeException();
		}
		
		this.tokens = tokens;
	}

	
	public int numOfParts() {
		return 1;
	}
	
	
	
}