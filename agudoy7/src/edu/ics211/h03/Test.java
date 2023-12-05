package edu.ics211.h03;

import edu.ics211.h02.LexScan;

public class Test {
    static LexScan scan = new LexScan();
    static String[][] tests = {scan.lexicalScanner("Hello World!"),    // invalid
                            scan.lexicalScanner("l = 2 + 2;"),         // assignment
                            scan.lexicalScanner("abc();"),             // method call
                            scan.lexicalScanner("if(a) else{}"),       // conditional
                            scan.lexicalScanner("while(true){}") };    // while loop

	public static void main(String[] args) throws InvalidStatementException {
        /*try{
            BasicStatement b = new BasicStatement(tests[0]);
        } catch(Exception e){
            p("InvalidStatementException thrown by BasicStatement");
        }

        try{
            BasicStatement b = new Assignment(tests[0]);
        } catch(Exception e){
            p("InvalidStatementException thrown by Assignment");
        }

        try{
            BasicStatement b = new MethodCall(tests[0]);
        } catch(Exception e){
            p("InvalidStatementException thrown by MethodCall");
        }

        try{
            CompoundStatement b = new Conditional(tests[0]);
        } catch(Exception e){
            p("InvalidStatementException thrown by Conditional");
        }

        try{
            CompoundStatement b = new WhileLoop(tests[0]);
        } catch(Exception e){
            p("InvalidStatementException thrown by WhileLoop");
        }*/

        BasicStatement bs1 = new Assignment(tests[1]);
        Assignment assignment = new Assignment(tests[1]);
        // p(bs1 == assignment);
        p(assignment.numTokens());
        p(assignment.getToken(0));

        BasicStatement bs2 = new MethodCall(tests[2]);
        MethodCall methodCall = new MethodCall(tests[2]);
        // p(bs2 == methodCall);
        p(methodCall.numTokens());
        p(methodCall.getToken(0));

        CompoundStatement cs1 = new Conditional(tests[3]);
        Conditional conditional = new Conditional(tests[3]);
        // p(cs1 == conditional);
        p(conditional.numTokens());
        p(conditional.getToken(0));

        CompoundStatement cs2 = new WhileLoop(tests[4]);
        WhileLoop whileLoop = new WhileLoop(tests[4]);
        // p(cs2 == whileLoop);
        p(whileLoop.numTokens());
        p(whileLoop.getToken(0));

	}

    public void invalid(){
        
    }

	public static <E> void p(E e){
		System.out.println(e);
	}
}
