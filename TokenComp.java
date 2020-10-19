import java.util.*;

enum TokenCompKind{
    INTEGER, IDENTIFIER, PUNCTUATION ,LITERAL, KEYWORD, NULL;
}

public class TokenComp {
    

    private TokenCompKind myKind;
    private String myValue;

    public TokenComp( String kind, String value) {

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
        else if (kind == "LITERAL") {
            myKind = TokenCompKind.LITERAL;
        }
        else {
            myKind = TokenCompKind.NULL;
        }


        myValue = value;
    }

    public String toString() {
        switch( myKind ) {
            case INTEGER:
                return "INTEGER TOKEN - " + myValue;
            case IDENTIFIER:
                return "IDENTIFIER TOKEN - " + myValue;
            case PUNCTUATION:
                return "PUNCTUATION TOKEN - " + myValue;
            case KEYWORD:
                return "KEYWORD TOKEN - " + myValue;
            case LITERAL:
                return "LITERAL TOKEN - " + myValue;
            case NULL:
                return "NULL TOKEN";
        }
        return "NULL TOKEN";
        
    }

    public static void main( String[] args) {

    }
}
