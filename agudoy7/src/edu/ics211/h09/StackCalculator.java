package edu.ics211.h09;

import java.util.EmptyStackException;

/**
 * StackCalculator
 * 
 * @author Benjamin Strauss
 * @author Alessandra Gudoy
 */
public class StackCalculator {
    private static final char[] USABLE_OPERATOR = { '+', '-', '*', '/', '÷', '^', '%' };

    private static LinkedNode operands;    // list of operands to operate on; head of list
    //private LinkedNode operators;
    private static int numOfOperands = 0;
    
    public static void main(String[] args){
        System.out.println(test4());
        System.out.println(test5());
    }

    public static boolean test4(){
        StackCalculator calc = new StackCalculator();
        try{
            calc.calculate('*');
            return false;
        } catch(Exception e){
            return true;
        }
    }

    public static boolean test5(){
        StackCalculator calc = new StackCalculator();
        calc.push(4);
        try{
            calc.calculate('*');
            return false;
        } catch(Exception e){
            return true;
        }
    }

     /**
     * Removes and returns top value of the stack
     * @return top value of the stack
     */
    public static long pop() {
        if(numOfOperands == 0){
            throw new EmptyStackException();
        }

        LinkedNode result = operands;
        operands = operands.next;
        numOfOperands = numOfOperands - 1;

		return result.item;
	}
	
    /**
     * Returns top value of the stack without removing
     * @return top value of the stack
     */
	public static long peek() {
		return operands.item;
	}
	
    /**
     * Adds a value onto the stack
     * @param value to add to the stack
     */
	public static void push(long newValue) {
		LinkedNode value = new LinkedNode(newValue, operands);
        operands = value;
        numOfOperands = numOfOperands + 1;
	}
	
    /**
     * Calculates the result of the first two operands using the given operator
     *      => result of the calculation pushed to the stack
     * @param operator to use in calculation
     */
	public static void calculate(char operator) {
		if(!isValidOperand(operator)) { throw new RuntimeException("Invalid Operand"); }
		if(operator == '÷') { operator = '/'; }

        long num2 = pop();
        long num1 = pop();
        long result = 0;
        boolean calculated = false;

        // System.out.println("NUM1 = " + num1 + "\t|\tNUM2 = " + num2);
        // System.out.print("CALUCLATING: ");

        switch(operator){
            case '+':
                result = num1 + num2;
                calculated = true;
                // System.out.println("SUM: " + (result));
                break;
            case '-':
                result = num1 - num2;
                calculated = true;
                // System.out.println("DIFFERENCE: " + (result));
                break;
            case '*':
                result = num1 * num2;
                calculated = true;
                // System.out.println("PRODUCT: " + (result));
                break;
            case '/':
                result = num1 / num2;
                calculated = true;
                // System.out.println("QUOTIENT: " + (result));
                break;
            case '^':
                result = (long) Math.pow(num1, num2);
                calculated = true;
                // System.out.println("POWER: " + (result));
                break;
            case '%':
                result = num1 % num2;
                calculated = true;
                // System.out.println("REMAINDER: " + (result));
                break;
        }

        if(calculated) { push(result); }
        else{ throw new RuntimeException("Something went wrong"); }
	}
	
	/**
	 * Checks to ensure the operand is valid
	 * @param operator to check
	 * @return true if given operator is valid
	 */
	private static boolean isValidOperand(char operator) {
		for(char ch: USABLE_OPERATOR) {
			if(ch == operator) { return true; }
		}
		return false;
	}

    /* * * LINKED NODE DEFINITION * * */

    protected static class LinkedNode{
        protected long item;
        protected LinkedNode next;

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
