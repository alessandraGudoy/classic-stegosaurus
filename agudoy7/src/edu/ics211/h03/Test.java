package edu.ics211.h03;

import java.util.Arrays;

import edu.ics211.h02.LexScan;

public class Test {
	public static void main(String[] args) throws InvalidStatementException {
		LexScan lex = new LexScan();
		
		String[] xArr = lex.lexicalScanner("y=35;");
		
		String[] yArr = lex.lexicalScanner("y=35;");
		
		String[] zArr = lex.lexicalScanner("if ( b ) { x = 0 ; } else { x = 1 ; }");
		
		Assignment x = new Assignment(xArr);
		Assignment y = new Assignment(yArr);
		Assignment z = new Assignment(new String[] {"y", "=", "5", ";"});
		
		Conditional statement = new Conditional(zArr);
		
		
		System.out.println(x.toString());
		System.out.println(statement.toString());
	}
}
