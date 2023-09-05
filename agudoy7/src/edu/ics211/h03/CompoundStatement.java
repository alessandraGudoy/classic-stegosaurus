package edu.ics211.h03;

public abstract class CompoundStatement extends Statement{

	public boolean isCompound() {
		return true;
	}
	
	public abstract int numOfParts();
	
}
