package edu.ics211;

/**
 * Please implement the below methods, using any class variables you need
 * Do not use any of the classes in java.util (excluding exceptions)
 * 			(Assignment was unclear on this, waiting for Edo's response...)
 * 
 * IMPORTANT: you do NOT have to implement Edo's 'String calculate(String[] args)' but only
 * 		the methods outlined below labeled "TODO".  There is no need to print anything;
 * 		printing to the console will not impact your grade
 * 
 * IMPORTANT: Do NOT zip your code!  You will be marked down!
 * 
 * @author Benjamin Strauss and [name]
 * 
 * Hint: Use Math.pow(a, b) to compute exponents
 *
 */

public class StackCalculator {
	private static final char[] USABLE_OPERANDS = { '+', '-', '*', '/', '÷', '^', '%' };
	
	//TODO need a stack class variable(s) 
	
	public long pop() {
		//TODO stub - to implement
		//remove and return top value of stack
		//if the stack is empty, throw java.util.EmptyStackException
		return 0;
	}
	
	public long peek() {
		//TODO stub - to implement
		//return top value of stack (don't remove!)
		return 0;
	}
	
	public void push(long value) {
		//TODO stub - to implement
		//push a value onto the stack
	}
	
	public void calculate(char operand) {
		if(!isValidOperand(operand)) { throw new RuntimeException("Invalid Operand"); }
		if(operand == '÷') { operand = '/'; }
		
		//TODO stub - to implement
		//takes an operand as input, and applies it to the top 2 values on the stack
		//		(if there are less than 2 values on the stack, throw java.util.EmptyStackException)
		//the resulting value is then pushed to the stack.
	}
	
	/**
	 * Checks to ensure the operand is valid
	 * @param operand
	 * @return
	 */
	private boolean isValidOperand(char operand) {
		for(char ch: USABLE_OPERANDS) {
			if(ch == operand) { return true; }
		}
		return false;
	}
	
	/**
	 * Main for student testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		//for student testing
	}
}
