package edu.ics211.h03;

import java.util.Objects;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class Conditional extends CompoundStatement{
	
	public Conditional() { super(); }

	public Conditional(String[] tokens) throws InvalidStatementException {
        super();
		
		Objects.requireNonNull(tokens);

		boolean elseFound = false;
		
		for(int i=2; i<tokens.length-1; i++) {
			if(tokens[i].equals("else")) {
				elseFound = true;
			}
		}
		
		if(!(tokens[0].equals("if") && tokens[1].equals("(") && 
				tokens[tokens.length-1].equals("}") && elseFound)) {
			throw new InvalidStatementException();
		}
		
		
		this.tokens = tokens;
	}

	
	public int numOfParts() {
		return 2;
	}
	
}
