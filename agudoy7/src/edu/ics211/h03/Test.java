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
		
		MethodCall method = new MethodCall(lex.lexicalScanner("methodName(asdf);"));
		//MethodCall notMethod = new MethodCall(lex.lexicalScanner("2(sd)"));
		
		WhileLoop whileLoop = new WhileLoop(lex.lexicalScanner("while(true)"));
		
		
		System.out.print(x.getToken(0));
		System.out.print(x.getVariable());
		System.out.println(method.toString());
	}
}
