package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public abstract class CompoundStatement extends Statement{
	
	public CompoundStatement() { }

	public CompoundStatement(String[] tokes) throws InvalidStatementException {
		if(isConditional(tokes) || isWhileLoop(tokes)) {
			this.tokens = tokes;
		} else {
			throw new InvalidStatementException();
		}
	}

	public boolean isCompound() {
		return true;
	}
	
	public abstract int numOfParts();
	
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
