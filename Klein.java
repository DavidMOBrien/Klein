public class Klein{
    
    public static void main(String[] args){
        String filename = args[0];

        ScannerComp scanner = new ScannerComp();

        scanner.getContent(filename);

        scanner.scanThru();

        scanner.getResults();
    }
}