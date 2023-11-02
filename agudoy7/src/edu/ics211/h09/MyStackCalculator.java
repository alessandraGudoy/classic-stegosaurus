package edu.ics211.h09;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * StackCalculator
 * 
 * @author Alessandra Gudoy
 */
public class MyStackCalculator {
    private static final String[] OPERATORS = {"+", "-", "*", "/", "÷", "^", "%"};

    public static void main(String[] args){
        System.out.println(calculate(args));
    }
    
    public static String calculate(String[] args){
        StringBuilder builder = new StringBuilder();

        for(String expression : args){
            String[] tokens = expression.split(" ");

            MyStack operands = new MyStack();
            MyStack operators = new MyStack();

            for(String str : tokens){
                if(true){

                }
            }

            
        }

        return builder.toString();
    }

    /* * * LINKED STACK DEFINITION * * */

    public static class MyStack{

        protected LinkedNode head;
        protected int size;
        protected boolean isEmpty;

        public MyStack(){
            isEmpty = true;
            size = 0;
            head = null;
        }

        /**
         * Adds given input to the top of the stack
         * @param newValue to be added to the stack
         */
        public void push(long newValue){
            LinkedNode value = new LinkedNode(newValue, head);
            head = value;
            size = size + 1;
        }

        /**
         * Removes and returns the top value of the stack
         * @return the top value of the stack
         * @throws EmptyStackException if stack is empty
         */
        public long pop(){
            if(head == null || size <= 0){
                throw new EmptyStackException();
            }

            LinkedNode result = head;
            head = head.next;

            size = size - 1;

            return result.item;
        }

        /**
         * Returns the top value of the stack without removing
         * @return the top value of the stack
         * @throws EmptyStackException if stack is empty
         */
        public long peek(){
            if(head == null || size <= 0){
                throw new EmptyStackException();
            }

            return head.item;
        }

        /**
         * Returns a boolean indicating if stack is empty
         * @return true if stack is empty
         */
        public boolean isEmpty(){
            return (size == 0);
        }

        /* * * LINKED NODE DEFINITION * * */

        protected class LinkedNode{
            protected long item;
            protected LinkedNode next;

            // default constructro
            public LinkedNode(){
                item = 0;
                next = null;
            }

            /**
             * constructor to build node without successor
             * @param value to be stored by this node
             */
            public LinkedNode(long value){
                item = value;
                next = null;
            }

            /**
             * constructor to build node with specified successor
             * @param value to be stored by this node
             * @param reference, the next node after this node
             */
            public LinkedNode(long value, LinkedNode reference){
                item = value;
                next = reference;
            }
        }

        /* * * LINKED NODE DEFINITION * * */
    }

    /* * * END OF LINKED STACK DEFINITION * * */
}
