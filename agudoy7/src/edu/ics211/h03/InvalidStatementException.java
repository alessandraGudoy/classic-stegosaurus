package edu.ics211.h03;

/**
 * 
 * @author Gudoy, Alessandra
 */

public class InvalidStatementException extends RuntimeException{

    public InvalidStatementException(){
        super();
    }

    public InvalidStatementException(String str){
        super(str);
    }

}
