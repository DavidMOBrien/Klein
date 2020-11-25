import java.util.*;

enum TokenCompKind{
    INTEGER, IDENTIFIER, PUNCTUATION ,BOOLEAN, KEYWORD, NULL, 
    PROGRAM, DEFINITIONS, DEF, FORMALS, NONEMPTYFORMALS, NONEMPTYFORMALS_ENDING,
    FORMAL, BODY, TYPE, EXPR, EXPR_ENDING, SIMPLEEXPR, SIMPLEEXPR_ENDING,
    TERM, TERM_ENDING, FACTOR, FACTOR_REST, ACTUALS, NONEMPTYACTUALS, NONEMPTYACTUALS_ENDING, LITERAL, PRINTSTATEMENT, ENDSTREAM
}

public class TokenComp {
    

    private TokenCompKind myKind;
    private String myValue;
    private boolean isTerminal;

    public TokenComp( String kind, String value, boolean termVal) {

        if (kind == "INTEGER") {
            myKind = TokenCompKind.INTEGER;
        }
        else if (kind == "IDENTIFIER") {
            myKind = TokenCompKind.IDENTIFIER;
        }
        else if (kind == "PUNCTUATION") {
            myKind = TokenCompKind.PUNCTUATION;
        }
        else if (kind == "KEYWORD") {
            myKind = TokenCompKind.KEYWORD;
        }
        else if (kind == "BOOLEAN") {
            myKind = TokenCompKind.BOOLEAN;
        }
        else if (kind == "PROGRAM") {
            myKind = TokenCompKind.PROGRAM;
        }
        else if (kind == "DEFINITIONS") {
            myKind = TokenCompKind.DEFINITIONS;
        }
        else if (kind == "DEF") {
            myKind = TokenCompKind.DEF;
        }
        else if (kind == "FORMALS") {
            myKind = TokenCompKind.FORMALS;
        }
        else if (kind == "NONEMPTYFORMALS") {
            myKind = TokenCompKind.NONEMPTYFORMALS;
        }
        else if (kind == "NONEMPTYFORMALS_ENDING") {
            myKind = TokenCompKind.NONEMPTYFORMALS_ENDING;
        }
        else if (kind == "FORMAL") {
            myKind = TokenCompKind.FORMAL;
        }
        else if (kind == "BODY") {
            myKind = TokenCompKind.BODY;
        }
        else if (kind == "TYPE") {
            myKind = TokenCompKind.TYPE;
        }
        else if (kind == "EXPR") {
            myKind = TokenCompKind.EXPR;
        }
        else if (kind == "EXPR_ENDING") {
            myKind = TokenCompKind.EXPR_ENDING;
        }
        else if (kind == "SIMPLEEXPR") {
            myKind = TokenCompKind.SIMPLEEXPR;
        }
        else if (kind == "SIMPLEEXPR_ENDING") {
            myKind = TokenCompKind.SIMPLEEXPR_ENDING;
        }
        else if (kind == "TERM") {
            myKind = TokenCompKind.TERM;
        }
        else if (kind == "TERM_ENDING") {
            myKind = TokenCompKind.TERM_ENDING;
        }
        else if (kind == "FACTOR") {
            myKind = TokenCompKind.FACTOR;
        }
        else if (kind == "FACTOR_REST") {
            myKind = TokenCompKind.FACTOR_REST;
        }
        else if (kind == "ACTUALS") {
            myKind = TokenCompKind.ACTUALS;
        }
        else if (kind == "NONEMPTYACTUALS") {
            myKind = TokenCompKind.NONEMPTYACTUALS;
        }
        else if (kind == "NONEMPTYACTUALS_ENDING") {
            myKind = TokenCompKind.NONEMPTYACTUALS_ENDING;
        }
        else if (kind == "LITERAL") {
            myKind = TokenCompKind.LITERAL;
        }
        else if (kind == "PRINTSTATEMENT") {
            myKind = TokenCompKind.PRINTSTATEMENT;
        }
        else if (kind == "ENDSTREAM") {
            myKind = TokenCompKind.ENDSTREAM;
        }
        else {
            myKind = TokenCompKind.NULL;
        }

        isTerminal = termVal;
        myValue = value;
    }

    public String toString() { //Used for Scanner to supply readability to user
        switch( myKind ) {
            case INTEGER:
                return "INTEGER TOKEN - " + myValue;
            case IDENTIFIER:
                return "IDENTIFIER TOKEN - " + myValue;
            case PUNCTUATION:
                return "PUNCTUATION TOKEN - " + myValue;
            case KEYWORD:
                return "KEYWORD TOKEN - " + myValue;
            case BOOLEAN:
                return "BOOLEAN TOKEN - " + myValue;
            case ENDSTREAM:
                return "$";
            case NULL:
                return "NULL TOKEN";
        }
        return "NULL TOKEN";
        
    }

    public String toRepresentation() { //used for Parser to tell what terminal a Token represents
        switch ( myKind ) {
            case INTEGER:
                return "NUMBER";
            case IDENTIFIER:
                if (myValue.equals("print")) {
                    return "print";
                }
                else {
                    return "IDENTIFIER";
                }
            case PUNCTUATION:
                return myValue;
            case KEYWORD:
                return myValue;
            case BOOLEAN:
                return "BOOLEAN";
            case ENDSTREAM:
                return "$";
            case NULL:
                return "NULL";
        }
        return "NULL";
    }

    public TokenCompKind getKind() {
        return myKind;
    }

    public String getValue() {
        return myValue;
    }

    public boolean satisfies(TokenComp compare) {
        if (myKind != compare.getKind()) {
            return false;
        }
        
        if ( (myKind == TokenCompKind.INTEGER) || (myKind == TokenCompKind.BOOLEAN) ) {
            return true;
        }
        if ( (myKind == TokenCompKind.PUNCTUATION) || (myKind == TokenCompKind.KEYWORD) ) {
            if (myValue.equals(compare.getValue())) {
                return true;
            }
            else {
                return false;
            }
        }
        if (myKind == TokenCompKind.IDENTIFIER) {
            if (myValue.equals("print")) {
                if (compare.getValue().equals("print")) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return true;
            }
        }

        return false;

    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public static void main( String[] args) {

    }
}
