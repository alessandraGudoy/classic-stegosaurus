package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class InvalidStatementException extends Exception{

    public InvalidStatementException(){ }

    public InvalidStatementException(String str){
        super(str);
    }

}
