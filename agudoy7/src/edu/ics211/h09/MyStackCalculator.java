package edu.ics211.h09;

/**
 * StackCalculator
 * 
 * @author Alessandra Gudoy
 */
public class MyStackCalculator {

    public static void main(String[] args){
        System.out.println(calculate(args));
    }
    
    public static String calculate(String[] args){
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<5; i++){
            builder.append(i);
            builder.append("\n");
        }

        return builder.toString();
    }

    public static class MyStack<E>{

    }
}
