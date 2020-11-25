import java.util.*;

public class Parser {

    CompExpansion expansion = new CompExpansion();
    ParseTable pt = new ParseTable();
    Stack<TokenComp> parseStack = new Stack<TokenComp>();
    ArrayList<TokenComp> programStream;

    public Parser(ArrayList<TokenComp> aStream) {
        
        programStream = aStream;

        boolean isLegal = parse();

        if (isLegal) {
            System.out.println("\nTHIS IS A LEGAL KLEIN PROGRAM");
        }
        
    }

    public boolean parse() {
        //following algorithm at http://www.cs.uni.edu/~wallingf/teaching/cs4550/sessions/session08.html#table-driven-algorithm
        //"Push end of stream symbol, $, onto stack"
        parseStack.push(new TokenComp("ENDSTREAM", "", true));

        //"Push the start symbol onto the stack"
        parseStack.push(new TokenComp("PROGRAM", "", false));

        //"Repeat until A (programStack.get(0)) == $"
        while(!parseStack.peek().toRepresentation().equals("$")) {
            // DEBUG: System.out.println(parseStack.peek().getKind());

            //if we have an empty token (meaning nothing is a suitable token for a requirement) we want to remove it and move on.
            if (parseStack.peek().getKind() == TokenCompKind.NULL) {
                System.out.println("Consuming: E ");
                parseStack.pop();
            }
            else if (programStream.size() == 0) {
                if (pt.hasKey(parseStack.peek().getKind(), "$")) {
                    parseStack.pop();
                }
            }
            else {
                TokenComp t = programStream.get(0);
                TokenComp A = parseStack.peek();
                //if A is a terminal
                if (A.isTerminal()) {
                    //If A == t, then Pop A from the stack and consume t
                    if (A.satisfies(t)) {
                        System.out.println("Consuming: " + t.toRepresentation());
                        programStream.remove(0);
                        parseStack.pop();
                    }
                    //Else we have a program mismatch. Fail.
                    else {
                        System.out.println("WE HAVE A TOKEN MISMATCH");
                        System.out.println("     - " + A.toString());
                        System.out.println("     - Not Satisfiable by");
                        System.out.println("     - " + t.toString());
                        return false;
                    }
                }
                //A is a non-terminal
                else {
                    //if table entry [A, t] contains a rule A := Y1,Y2,....Yn, then...
                    if (pt.hasKey(A.getKind(), t.toRepresentation())) {

                        //used to expand rule later...
                        String ruleID = pt.find(A.getKind(), t.toRepresentation());
                        System.out.println("RuleID: " + ruleID);

                        //Pop A from the stack.
                        parseStack.pop();

                        //expand the rule
                        TokenComp[] expandedRules = expansion.lookup(ruleID);

                        //Push Yn, Yn-1, ... Y1 onto the stack, in that order
                        if (expandedRules.length <= 1) {
                            parseStack.push(expandedRules[0]);
                        }
                        else {
                            for (int counter = expandedRules.length -1; counter >= 0; counter--) {
                                parseStack.push(expandedRules[counter]);
                            }
                        }
                    }
                    //Else there is no transition for this pair. Fail.
                    else {
                        System.out.println("THERE IS NO TRANSITION FOR THIS PAIR:");
                        System.out.println("     - " + A.getKind());
                        System.out.println("     - AND");
                        System.out.println("     - " + t.toRepresentation());
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}