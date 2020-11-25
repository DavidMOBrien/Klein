import java.util.*;

public class CompExpansion {

    Hashtable<String,TokenComp[]> expDict = new Hashtable<String, TokenComp[]>();
    
    public CompExpansion() {
        // <PROGRAM> ::= <DEFINITIONS>
        expDict.put("PROGRAM_RULE1", new TokenComp[] { new TokenComp("DEFINITIONS", "", false) } );

        //<DEFINITIONS> ::= E
	    //                | <DEF> <DEFINITIONS>
        expDict.put("DEFINITIONS_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("DEFINITIONS_RULE2", new TokenComp[] { new TokenComp("DEF", "", false),
                                                           new TokenComp("DEFINITIONS", "", false) } );
        
        //<DEF> ::= function <IDENTIFIER> ( <FORMALS> ) : <TYPE>
		//      <BODY>
        expDict.put("DEF_RULE1", new TokenComp[] { new TokenComp("KEYWORD", "function", true),
                                                   new TokenComp("IDENTIFIER", "", true),
                                                   new TokenComp("PUNCTUATION", "(", true),
                                                   new TokenComp("FORMALS", "", false),
                                                   new TokenComp("PUNCTUATION", ")", true),
                                                   new TokenComp("PUNCTUATION", ":", true),
                                                   new TokenComp("TYPE", "", false),
                                                   new TokenComp("BODY", "", false)  } );
        
        //<FORMALS> ::= E
        //            | <NONEMPTYFORMALS>
        expDict.put("FORMALS_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("FORMALS_RULE2", new TokenComp[] { new TokenComp("NONEMPTYFORMALS", "", false) } );

        //<NONEMPTYFORMALS> ::= <FORMAL> <NONEMPTYFORMALS_ENDING>
        expDict.put("NONEMPTYFORMALS_RULE1", new TokenComp[] { new TokenComp("FORMAL", "", false),
                                                               new TokenComp("NONEMPTYFORMALS_ENDING", "", false)} );

        //<NONEMPTYFORMALS_ENDING> ::= E
        //	                         | , <NONEMPTYFORMALS>
        expDict.put("NONEMPTYFORMALS_ENDING_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("NONEMPTYFORMALS_ENDING_RULE2", new TokenComp[] { new TokenComp("PUNCTUATION", ",", true),
                                                                      new TokenComp("NONEMPTYFORMALS", "", false)} );

        //<FORMAL> ::= <IDENTIFIER> : <TYPE>
        expDict.put("FORMAL_RULE1", new TokenComp[] { new TokenComp("IDENTIFIER", "", true),
                                                      new TokenComp("PUNCTUATION", ":", true),
                                                      new TokenComp("TYPE", "", false) } );


        //<BODY> ::= <PRINT-STATEMENT> <BODY>
        //         | <EXPR>
        expDict.put("BODY_RULE1", new TokenComp[] { new TokenComp("PRINTSTATEMENT", "", false),
                                                    new TokenComp("BODY", "", false)} );
        expDict.put("BODY_RULE2", new TokenComp[] { new TokenComp("EXPR", "", false) } );

        //<TYPE> ::= INTEGER
        //         | BOOLEAN
        expDict.put("TYPE_RULE1", new TokenComp[] { new TokenComp("KEYWORD", "boolean", true) } );
        expDict.put("TYPE_RULE2", new TokenComp[] { new TokenComp("KEYWORD", "integer", true) } );

        //<EXPR> ::= <SIMPLE-EXPR> <EXPR_ENDING>
        expDict.put("EXPR_RULE1", new TokenComp[] { new TokenComp("SIMPLEEXPR", "", false),
                                                    new TokenComp("EXPR_ENDING", "", false)} );

        //<EXPR_ENDING> ::= E
		//                | < <SIMPLE-EXPR>
        //                | = <SIMPLE-EXPR>
        expDict.put("EXPR_ENDING_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("EXPR_ENDING_RULE2", new TokenComp[] { new TokenComp("PUNCTUATION", "<", true),
                                                           new TokenComp("SIMPLEEXPR", "", false) } );
        expDict.put("EXPR_ENDING_RULE3", new TokenComp[] { new TokenComp("PUNCTUATION", "=", true),
                                                           new TokenComp("SIMPLEEXPR", "", false) } );

        //<SIMPLE-EXPR> ::= <TERM> <SIMPLE-EXPR_ENDING>
        expDict.put("SIMPLEEXPR_RULE1", new TokenComp[] { new TokenComp("TERM", "", false),
                                                          new TokenComp("SIMPLEEXPR_ENDING", "", false)} );

        //<SIMPLE-EXPR_ENDING> ::= E
        //                       | + <TERM>
        //                       | - <TERM>
        //                       | or <TERM>
        expDict.put("SIMPLEEXPR_ENDING_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("SIMPLEEXPR_ENDING_RULE2", new TokenComp[] { new TokenComp("PUNCTUATION", "+", true),
                                                                 new TokenComp("TERM", "", false) } );
        expDict.put("SIMPLEEXPR_ENDING_RULE3", new TokenComp[] { new TokenComp("PUNCTUATION", "-", true),
                                                                 new TokenComp("TERM", "", false) } );
        expDict.put("SIMPLEEXPR_ENDING_RULE4", new TokenComp[] { new TokenComp("KEYWORD", "or", true),
                                                                 new TokenComp("TERM", "", false) } );

        //<TERM> ::= <FACTOR> <TERM_ENDING>
        expDict.put("TERM_RULE1", new TokenComp[] { new TokenComp("FACTOR", "", false),
                                                    new TokenComp("TERM_ENDING", "", false)} );

        //<TERM_ENDING> ::= E
	    //                | * <FACTOR>
        //                | / <FACTOR>
        //                | and <FACTOR>
        expDict.put("TERM_ENDING_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("TERM_ENDING_RULE2", new TokenComp[] { new TokenComp("PUNCTUATION", "*", true),
                                                           new TokenComp("FACTOR", "", false) } );
        expDict.put("TERM_ENDING_RULE3", new TokenComp[] { new TokenComp("PUNCTUATION", "/", true),
                                                           new TokenComp("FACTOR", "", false) } );
        expDict.put("TERM_ENDING_RULE4", new TokenComp[] { new TokenComp("KEYWORD", "and", true),
                                                           new TokenComp("FACTOR", "", false) } );

        //<FACTOR> ::= if <EXPR> then <EXPR> else <EXPR>
        //           | not <FACTOR>
        //           | <IDENTIFIER> <FACTOR_REST>
        //           | <LITERAL>
        //           | - <FACTOR>
        //           | ( <EXPR> )
        expDict.put("FACTOR_RULE1", new TokenComp[] { new TokenComp("KEYWORD", "if", true),
                                                      new TokenComp("EXPR", "", false),
                                                      new TokenComp("KEYWORD", "then", true),
                                                      new TokenComp("EXPR", "", false),
                                                      new TokenComp("KEYWORD", "else", true),
                                                      new TokenComp("EXPR", "", false) } );
        expDict.put("FACTOR_RULE2", new TokenComp[] { new TokenComp("KEYWORD", "not", true),
                                                      new TokenComp("FACTOR", "", false) } );
        expDict.put("FACTOR_RULE3", new TokenComp[] { new TokenComp("IDENTIFIER", "", true),
                                                      new TokenComp("FACTOR_REST", "", false) } );
        expDict.put("FACTOR_RULE4", new TokenComp[] { new TokenComp("LITERAL", "", false) } );
        expDict.put("FACTOR_RULE5", new TokenComp[] { new TokenComp("PUNCTUATION", "-", true),
                                                      new TokenComp("FACTOR", "", false) } );
        expDict.put("FACTOR_RULE6", new TokenComp[] { new TokenComp("PUNCTUATION", "(", true),
                                                      new TokenComp("EXPR", "", false),
                                                      new TokenComp("PUNCTUATION", ")", true) } );

        //<FACTOR_REST> ::= E
        //                | ( <ACTUALS> )
        expDict.put("FACTOR_REST_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("FACTOR_REST_RULE2", new TokenComp[] { new TokenComp("PUNCTUATION", "(", true),
                                                           new TokenComp("ACTUALS", "", false),
                                                           new TokenComp("PUNCTUATION", ")", true) } );

        //<ACTUALS> ::= E
        //            | <NONEMPTYACTUALS>
        expDict.put("ACTUALS_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("ACTUALS_RULE2", new TokenComp[] { new TokenComp("NONEMPTYACTUALS", "", false) } );

        //<NONEMPTYACTUALS> ::= <EXPR> <NONEMPTYACTUALS_ENDING>
        expDict.put("NONEMPTYACTUALS_RULE1", new TokenComp[] { new TokenComp("EXPR", "", false),
                                                               new TokenComp("NONEMPTYACTUALS_ENDING", "", false) } );

        //<NONEMPTYACTUALS_ENDING> ::= E
        //                           | , <NONEMPTYACTUALS>
        expDict.put("NONEMPTYACTUALS_ENDING_RULE1", new TokenComp[] { new TokenComp("NULL", "", true) } );
        expDict.put("NONEMPTYACTUALS_ENDING_RULE2", new TokenComp[] { new TokenComp("PUNCTUATION", ",", true),
                                                                      new TokenComp("NONEMPTYACTUALS", "", false)} );

        //<LITERAL> ::= <NUMBER>
        //            | <BOOLEAN>
        expDict.put("LITERAL_RULE1", new TokenComp[] { new TokenComp("INTEGER", "", true) } );
        expDict.put("LITERAL_RULE2", new TokenComp[] { new TokenComp("BOOLEAN", "", true) } );

        //<PRINT-STATEMENT> ::= print ( <EXPR> )
        expDict.put("PRINTSTATEMENT_RULE1", new TokenComp[] { new TokenComp("IDENTIFIER", "print", true),
                                                              new TokenComp("PUNCTUATION", "(", true),
                                                              new TokenComp("EXPR", "", false),
                                                              new TokenComp("PUNCTUATION", ")", true) } );

    }

    public TokenComp[] lookup(String ruleName) {
        return expDict.get(ruleName);
    }


    public static void main(String[] args) {

        

    }
}