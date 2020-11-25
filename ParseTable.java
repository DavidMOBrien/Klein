import java.util.*;

public class ParseTable{

    Map<TokenCompKind, Map<String,String>> masterDict = new HashMap<TokenCompKind, Map<String, String>>();
    HashMap<String,String> temporaryDict = new HashMap<String,String>();

    public ParseTable() {

        //PROGRAM PARSE-TABLE ENTRIES
        temporaryDict.put("function", "PROGRAM_RULE1");
        temporaryDict.put("$", "PROGRAM_RULE1");
        masterDict.put(TokenCompKind.PROGRAM, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //DEFINITIONS PARSE-TABLE ENTRIES
        temporaryDict.put("function", "DEFINITIONS_RULE2");
        temporaryDict.put("$", "DEFINITIONS_RULE1");
        masterDict.put(TokenCompKind.DEFINITIONS, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //DEF PARSE-TABLE ENTRIES
        temporaryDict.put("function", "DEF_RULE1");
        masterDict.put(TokenCompKind.DEF, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //FORMALS PARSE-TABLE ENTRIES
        temporaryDict.put(")", "FORMALS_RULE1");
        temporaryDict.put("IDENTIFIER", "FORMALS_RULE2");
        masterDict.put(TokenCompKind.FORMALS, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //NONEMPTYFORMALS PARSE-TABLE ENTRIES
        temporaryDict.put("IDENTIFIER", "NONEMPTYFORMALS_RULE1");
        temporaryDict.put(")", "NONEMPTYFORMALS_RULE1");
        masterDict.put(TokenCompKind.NONEMPTYFORMALS, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //NONEMPTYFORMALS_ENDING PARSE-TABLE ENTRIES
        temporaryDict.put(")", "NONEMPTYFORMALS_ENDING_RULE1");
        temporaryDict.put(",", "NONEMPTYFORMALS_ENDING_RULE2");
        masterDict.put(TokenCompKind.NONEMPTYFORMALS_ENDING, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //FORMAL PARSE-TABLE ENTRIES
        temporaryDict.put("IDENTIFIER", "FORMAL_RULE1");
        masterDict.put(TokenCompKind.FORMAL, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //BODY PARSE-TABLE ENTRIES
        temporaryDict.put("print", "BODY_RULE1");
        temporaryDict.put("if", "BODY_RULE2");
        temporaryDict.put("not", "BODY_RULE2");
        temporaryDict.put("NUMBER", "BODY_RULE2");
        temporaryDict.put("BOOLEAN", "BODY_RULE2");
        temporaryDict.put("-", "BODY_RULE2");
        temporaryDict.put("IDENTIFIER", "BODY_RULE2");
        temporaryDict.put("(", "BODY_RULE2");
        masterDict.put(TokenCompKind.BODY, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //TYPE PARSE-TABLE ENTRIES
        temporaryDict.put("boolean", "TYPE_RULE1");
        temporaryDict.put("integer", "TYPE_RULE2");
        masterDict.put(TokenCompKind.TYPE, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //EXPR PARSE-TABLE ENTRIES
        temporaryDict.put("if", "EXPR_RULE1");
        temporaryDict.put("not", "EXPR_RULE1");
        temporaryDict.put("NUMBER", "EXPR_RULE1");
        temporaryDict.put("BOOLEAN", "EXPR_RULE1");
        temporaryDict.put("-", "EXPR_RULE1");
        temporaryDict.put("IDENTIFIER", "EXPR_RULE1");
        temporaryDict.put("(", "EXPR_RULE1");
        masterDict.put(TokenCompKind.EXPR, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //EXPR_ENDING PARSE-TABLE ENTRIES
        temporaryDict.put("if", "EXPR_ENDING_RULE1");
        temporaryDict.put("then", "EXPR_ENDING_RULE1");
        temporaryDict.put("else", "EXPR_ENDING_RULE1");
        temporaryDict.put("not", "EXPR_ENDING_RULE1");
        temporaryDict.put("and", "EXPR_ENDING_RULE1");
        temporaryDict.put("or", "EXPR_ENDING_RULE1");
        temporaryDict.put("function", "EXPR_ENDING_RULE1");
        temporaryDict.put("NUMBER", "EXPR_ENDING_RULE1");
        temporaryDict.put("BOOLEAN", "EXPR_ENDING_RULE1");
        temporaryDict.put("<", "EXPR_ENDING_RULE2");
        temporaryDict.put("=", "EXPR_ENDING_RULE3");
        temporaryDict.put("+", "EXPR_ENDING_RULE1");
        temporaryDict.put("-", "EXPR_ENDING_RULE1");
        temporaryDict.put("*", "EXPR_ENDING_RULE1");
        temporaryDict.put("/", "EXPR_ENDING_RULE1");
        temporaryDict.put(",", "EXPR_ENDING_RULE1");
        temporaryDict.put("IDENTIFIER", "EXPR_ENDING_RULE1");
        temporaryDict.put("(", "EXPR_ENDING_RULE1");
        temporaryDict.put(")", "EXPR_ENDING_RULE1");
        temporaryDict.put("$", "EXPR_ENDING_RULE1");
        masterDict.put(TokenCompKind.EXPR_ENDING, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //SIMPLEEXPR PARSE-TABLE ENTRIES
        temporaryDict.put("if", "SIMPLEEXPR_RULE1");
        temporaryDict.put("not", "SIMPLEEXPR_RULE1");
        temporaryDict.put("NUMBER", "SIMPLEEXPR_RULE1");
        temporaryDict.put("BOOLEAN", "SIMPLEEXPR_RULE1");
        temporaryDict.put("-", "SIMPLEEXPR_RULE1");
        temporaryDict.put("IDENTIFIER", "SIMPLEEXPR_RULE1");
        temporaryDict.put("(", "SIMPLEEXPR_RULE1");
        masterDict.put(TokenCompKind.SIMPLEEXPR, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //SIMPLEEXPR_ENDING PARSE-TABLE ENTRIES
        temporaryDict.put("if", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("then", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("else", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("not", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("and", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("or", "SIMPLEEXPR_ENDING_RULE4");
        temporaryDict.put("function", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("NUMBER", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("BOOLEAN", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("<", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("=", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("+", "SIMPLEEXPR_ENDING_RULE2");
        temporaryDict.put("-", "SIMPLEEXPR_ENDING_RULE3");
        temporaryDict.put("*", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("/", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put(",", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("IDENTIFIER", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("(", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put(")", "SIMPLEEXPR_ENDING_RULE1");
        temporaryDict.put("$", "SIMPLEEXPR_ENDING_RULE1");
        masterDict.put(TokenCompKind.SIMPLEEXPR_ENDING, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //TERM PARSE-TABLE ENTRIES
        temporaryDict.put("if", "TERM_RULE1");
        temporaryDict.put("not", "TERM_RULE1");
        temporaryDict.put("NUMBER", "TERM_RULE1");
        temporaryDict.put("BOOLEAN", "TERM_RULE1");
        temporaryDict.put("-", "TERM_RULE1");
        temporaryDict.put("IDENTIFIER", "TERM_RULE1");
        temporaryDict.put("(", "TERM_RULE1");
        masterDict.put(TokenCompKind.TERM, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //TERM_ENDING PARSE-TABLE ENTRIES
        temporaryDict.put("if", "TERM_ENDING_RULE1");
        temporaryDict.put("then", "TERM_ENDING_RULE1");
        temporaryDict.put("else", "TERM_ENDING_RULE1");
        temporaryDict.put("not", "TERM_ENDING_RULE1");
        temporaryDict.put("and", "TERM_ENDING_RULE4");
        temporaryDict.put("or", "TERM_ENDING_RULE1");
        temporaryDict.put("function", "TERM_ENDING_RULE1");
        temporaryDict.put("NUMBER", "TERM_ENDING_RULE1");
        temporaryDict.put("BOOLEAN", "TERM_ENDING_RULE1");
        temporaryDict.put("<", "TERM_ENDING_RULE1");
        temporaryDict.put("=", "TERM_ENDING_RULE1");
        temporaryDict.put("+", "TERM_ENDING_RULE1");
        temporaryDict.put("-", "TERM_ENDING_RULE1");
        temporaryDict.put("*", "TERM_ENDING_RULE2");
        temporaryDict.put("/", "TERM_ENDING_RULE3");
        temporaryDict.put(",", "TERM_ENDING_RULE1");
        temporaryDict.put("IDENTIFIER", "TERM_ENDING_RULE1");
        temporaryDict.put("(", "TERM_ENDING_RULE1");
        temporaryDict.put(")", "TERM_ENDING_RULE1");
        temporaryDict.put("$", "TERM_ENDING_RULE1");
        masterDict.put(TokenCompKind.TERM_ENDING, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();
        
        //FACTOR PARSE-TABLE ENTRIES
        temporaryDict.put("if", "FACTOR_RULE1");
        temporaryDict.put("not", "FACTOR_RULE2");
        temporaryDict.put("NUMBER", "FACTOR_RULE4");
        temporaryDict.put("BOOLEAN", "FACTOR_RULE4");
        temporaryDict.put("-", "FACTOR_RULE5");
        temporaryDict.put("IDENTIFIER", "FACTOR_RULE3");
        temporaryDict.put("(", "FACTOR_RULE6");
        masterDict.put(TokenCompKind.FACTOR, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //FACTOR_REST PARSE-TABLE ENTRIES
        temporaryDict.put("if", "FACTOR_REST_RULE1");
        temporaryDict.put("then", "FACTOR_REST_RULE1");
        temporaryDict.put("else", "FACTOR_REST_RULE1");
        temporaryDict.put("not", "FACTOR_REST_RULE1");
        temporaryDict.put("and", "FACTOR_REST_RULE1");
        temporaryDict.put("or", "FACTOR_REST_RULE1");
        temporaryDict.put("function", "FACTOR_REST_RULE1");
        temporaryDict.put("NUMBER", "FACTOR_REST_RULE1");
        temporaryDict.put("BOOLEAN", "FACTOR_REST_RULE1");
        temporaryDict.put("<", "FACTOR_REST_RULE1");
        temporaryDict.put("=", "FACTOR_REST_RULE1");
        temporaryDict.put("+", "FACTOR_REST_RULE1");
        temporaryDict.put("-", "FACTOR_REST_RULE1");
        temporaryDict.put("*", "FACTOR_REST_RULE1");
        temporaryDict.put("/", "FACTOR_REST_RULE1");
        temporaryDict.put(",", "FACTOR_REST_RULE1");
        temporaryDict.put("IDENTIFIER", "FACTOR_REST_RULE1");
        temporaryDict.put("(", "FACTOR_REST_RULE2");
        temporaryDict.put(")", "FACTOR_REST_RULE1");
        temporaryDict.put("$", "FACTOR_REST_RULE1");
        masterDict.put(TokenCompKind.FACTOR_REST, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //ACTUALS PARSE-TABLE ENTRIES
        temporaryDict.put("if", "ACTUALS_RULE2");
        temporaryDict.put("not", "ACTUALS_RULE2");
        temporaryDict.put("NUMBER", "ACTUALS_RULE2");
        temporaryDict.put("BOOLEAN", "ACTUALS_RULE2");
        temporaryDict.put("-", "ACTUALS_RULE2");
        temporaryDict.put("IDENTIFIER", "ACTUALS_RULE2");
        temporaryDict.put("(", "ACTUALS_RULE2");
        temporaryDict.put(")", "ACTUALS_RULE1");
        masterDict.put(TokenCompKind.ACTUALS, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //NONEMPTYACTUALS PARSE-TABLE ENTRIES
        temporaryDict.put("if", "NONEMPTYACTUALS_RULE1");
        temporaryDict.put("not", "NONEMPTYACTUALS_RULE1");
        temporaryDict.put("NUMBER", "NONEMPTYACTUALS_RULE1");
        temporaryDict.put("BOOLEAN", "NONEMPTYACTUALS_RULE1");
        temporaryDict.put("-", "NONEMPTYACTUALS_RULE1");
        temporaryDict.put("IDENTIFIER", "NONEMPTYACTUALS_RULE1");
        temporaryDict.put("(", "NONEMPTYACTUALS_RULE1");
        masterDict.put(TokenCompKind.NONEMPTYACTUALS, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //NONEMPTYACTUALS_ENDING PARSE-TABLE ENTRIES
        temporaryDict.put(",", "NONEMPTYACTUALS_ENDING_RULE2");
        temporaryDict.put(")", "NONEMPTYACTUALS_ENDING_RULE1");
        masterDict.put(TokenCompKind.NONEMPTYACTUALS_ENDING, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //LITERAL PARSE-TABLE ENTRIES
        temporaryDict.put("NUMBER", "LITERAL_RULE1");
        temporaryDict.put("BOOLEAN", "LITERAL_RULE2");
        masterDict.put(TokenCompKind.LITERAL, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

        //PRINTSTATEMENT PARSE-TABLE ENTRIES
        temporaryDict.put("print", "PRINTSTATEMENT_RULE1");
        masterDict.put(TokenCompKind.PRINTSTATEMENT, new HashMap<String,String>(temporaryDict));
        temporaryDict.clear();

    }

    public boolean hasKey(TokenCompKind aKind, String aTokenRep) {
        return masterDict.get(aKind).containsKey(aTokenRep);
    }

    public String find(TokenCompKind aKind, String aTokenRep) {
        return masterDict.get(aKind).get(aTokenRep);
    }
    public static void main(String[] args) {

    }
    
}