package edu.ics211.h03;

import java.util.Arrays;

import edu.ics211.h02.LexScan;

public class Test {
	public static void main(String[] args) throws InvalidStatementException {
		LexScan scan = new LexScan();

		String[] statement = scan.lexicalScanner("l = 2 + 2;");
		
		Statement statementObj = new Assignment(statement);
		BasicStatement assignment = new Assignment(scan.lexicalScanner("l = 2 + 2;"));

		CompoundStatement in = new Conditional(scan.lexicalScanner("if(a) else{}"));
		CompoundStatement eWhile = new WhileLoop(scan.lexicalScanner("while(true){}"));

		p(in.numOfParts());

		String[] basicStatement = scan.lexicalScanner("null");
		String[] basicAssignment = scan.lexicalScanner("null");
		String[] basicMethodCall = scan.lexicalScanner("null");

		String[] compoundStatement = scan.lexicalScanner("null");
		String[] compoundConditional = scan.lexicalScanner("null");
		String[] compountWhile = scan.lexicalScanner("null");
	}

	public static <E> void p(E e){
		System.out.println(e);
	}
}
