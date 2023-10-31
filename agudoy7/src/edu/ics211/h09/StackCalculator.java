package edu.ics211.h09;

/**
 * StackCalculator
 * 
 * @author Benjamin Strauss
 * @author Alessandra Gudoy
 */
public class StackCalculator {
    private static final char[] USABLE_OPERANDS = { '+', '-', '*', '/', '÷', '^', '%' };

    private LinkedNode head;
    
    public static void main(String[] args){

    }

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

    /* * * LINKED NODE DEFINITION * * */

    public static class LinkedNode{
        private long item;
        private LinkedNode next;

        // default constructor
        public LinkedNode(){
            item = 0;
            next = null;
        }

        /**
         * constructor to build a node with no successor
         * @param value to be stored by this node
         */
        public LinkedNode(long value){
            item = value;
            next = null;
        }

        /**
         * constructor to build a node with specified successor
         * @param value to be stored by this node
         * @param reference, the next field for this node
         */
        public LinkedNode(long value, LinkedNode reference){
            item = value;
            next = reference;
        }
    }

    /* * * END OF LINKED NODE DEFINITION * * */

}
