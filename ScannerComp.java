import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


enum CurrentState{
    SEARCHING, INTEGER, STRING;
}

public class ScannerComp {

    private ArrayList<String> content;
    private CurrentState cs;
    private ArrayList<TokenComp> results;
    private String acc;
    private ArrayList<String> kw;

    public ScannerComp() {

        cs = CurrentState.SEARCHING;
        content = new ArrayList<String>();
        results = new ArrayList<TokenComp>();
        acc = "";

        kw = new ArrayList<String>();
        kw.add("integer");
        kw.add("boolean");
        kw.add("if");
        kw.add("not");
        kw.add("then");
        kw.add("else");
        kw.add("and");
        kw.add("or");
        kw.add("function");

    }
    
    public void getContent(String filename){

        //Retrieve program file to read
        try {

            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                content.add(data);
            }

            myReader.close();

          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          } //end try / catch

    }

    public void scanThru(){

        for (int i = 0; i < content.size(); i++ ) {

            String line = content.get(i);

            for (int j = 0; j < line.length(); j++){
                char currentChar = line.charAt(j);
                    
                switch (cs) {

                    case SEARCHING:

                        if ("1234567890".indexOf(currentChar) != -1) {

                            acc += currentChar;
                            if (j == line.length() -1) {
                                results.add(new TokenComp( "INTEGER", acc));
                                acc = "";
                            }
                            else {
                                cs = CurrentState.INTEGER;
                            }
                            
                        }

                        if ("AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".indexOf(currentChar) != -1) {

                            acc += currentChar;
                            if (j == line.length() -1) {
                                results.add(new TokenComp( "IDENTIFIER", acc));
                                acc = "";
                            }
                            else {
                                cs = CurrentState.STRING;
                            }
                            

                        }

                        findPunctuation(currentChar, line, j);

                        break;
                    
                    case INTEGER:

                        if ("1234567890".indexOf(currentChar) != -1) {
                            acc += currentChar;
                        }

                        if ((" ()+<'-=:/'*".indexOf(currentChar) != -1) || (j == line.length() -1)) {
                            cs = CurrentState.SEARCHING;
                            results.add(new TokenComp( "INTEGER", acc));
                            acc = "";

                            findPunctuation(currentChar, line, j);

                        }

                        break;
                    
                    case STRING:
                        
                        if ("1234567890AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz".indexOf(currentChar) != -1) {
                            acc += currentChar;
                        }

                        if ((" ()+<'-=:/'*".indexOf(currentChar) != -1) || (j == line.length() -1)) {

                            cs = CurrentState.SEARCHING;

                            if ((acc == "true") || (acc == "false")) {
                                results.add(new TokenComp("LITERAL", acc));
                            }

                            else if (kw.contains(acc)) {
                                results.add(new TokenComp("KEYWORD", acc));
                            }

                            else {
                                results.add(new TokenComp("IDENTIFIER", acc));
                            }

                            acc = "";
                            
                            findPunctuation(currentChar, line, j);

                        }

                        break;

                }

            }

        }

    }

    public void getResults() {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    public void findPunctuation(char currentChar, String currentLine, int currentIndex) {

        if ("+<'-=:/'".indexOf(currentChar) != -1) {
            results.add(new TokenComp("PUNCTUATION", String.valueOf(currentChar)));
        }

        if (currentChar == '(' ) {
            if (currentLine.charAt(currentIndex + 1) == '*') {
                results.add(new TokenComp("PUNCTUATION", "(*"));
            }
            else {
                results.add(new TokenComp("PUNCTUATION", "("));
            }
        }

        if (currentChar == '*') {
            if (currentLine.charAt(currentIndex - 1) != '(') {
                if (currentLine.charAt(currentIndex + 1) == ')') {
                    results.add(new TokenComp("PUNCTUATION", "*)"));
                }
                else {
                    results.add(new TokenComp("PUNCTUATION", "*"));
                }
            }
        }

        
        if (currentChar == ')' ) {
            if (currentLine.charAt(currentIndex - 1) != '*') {
                results.add(new TokenComp("PUNCTUATION", ")"));
            }
        }

    }
    public static void main(String[] args) {
        
    }

} //end ScannerComp