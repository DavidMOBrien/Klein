import java.util.*;

public class Klein{
    
    public static void main(String[] args){
        String filename = args[0];

        //String filename = "sampleProgram.txt";

        ScannerComp scanner = new ScannerComp();

        scanner.getContent(filename);

        scanner.scanThru();

        System.out.println("------- SCANNER RESULTS --------");
        scanner.printResults();

        ArrayList<TokenComp> scanResults = scanner.getResults();

        System.out.println("\n");
        System.out.println("------- PARSER RESULTS --------");
        Parser parser = new Parser(scanResults);

    }
}