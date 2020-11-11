import java.util.Scanner;
import static java.lang.Thread.sleep;

public class Main {

    public static void inputLoop(String pdaDescrFile, String pdaTestStringsFile ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! This program will import the PDA description and PDA test strings from given input files... " +
                "\n\tWhen prompted, enter the word 'exit' in order to exit the loop");

        while (!pdaDescrFile.toLowerCase().equals("exit") && !pdaTestStringsFile.toLowerCase().equals("exit")){
            System.out.printf("\nPDADescription from '%s', and testStrings from '%s'\n\tNow creating and testing the PDA...\n", pdaDescrFile, pdaTestStringsFile);
            PDA pda = new PDA(pdaDescrFile, pdaTestStringsFile);
            pda.run();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Please enter a filename from which to import the next PDA description: ");
            pdaDescrFile = scanner.next();
            if (pdaDescrFile.toLowerCase().equals("exit"))
                break;
            System.out.println("Please enter a filename from which to import the next input strings to be tested by the PDA: ");
            pdaTestStringsFile = scanner.next();
        }
        System.out.println("Now exiting the program... Goodbye!");
    }

    public static void inputLoop(){
        String pdaDescrFile, pdaTestStringsFile;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! This program will import the PDA description and PDA test strings from given input files... " +
                "\n\tWhen prompted, enter the word 'exit' in order to exit the loop");
        System.out.println("Please enter a filename from which to import the PDA description: ");
        pdaDescrFile = scanner.next();
        System.out.println("Please enter a filename from which to import the input strings to be tested by the PDA: ");
        pdaTestStringsFile = scanner.next();

        while (!pdaDescrFile.toLowerCase().equals("exit") && !pdaTestStringsFile.toLowerCase().equals("exit")){
            System.out.printf("\nPDADescription from '%s', and testStrings from '%s'\n\tNow creating and testing the PDA...\n", pdaDescrFile, pdaTestStringsFile);
            PDA pda = new PDA(pdaDescrFile, pdaTestStringsFile);
            pda.run();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Please enter a filename from which to import the next PDA description: ");
            pdaDescrFile = scanner.next();
            if (pdaDescrFile.toLowerCase().equals("exit"))
                break;
            System.out.println("Please enter a filename from which to import the next input strings to be tested by the PDA: ");
            pdaTestStringsFile = scanner.next();
        }
        System.out.println("Now exiting the program... Goodbye!");
    }

    public static void main(String[] args) {
        // args structure needs to be:
        //  args[0] == the PDADescription input file      ex. 'input1.txt'
        //  args[1] == the testInput input file     ex. 'testInput1.txt'
        //
        //  Else, the program will execute the inputLoop function
        //
        if (args.length == 2){
            String pdaDescription = args[0], pdaInputStrings = args[1];
            System.out.println("2 command line arguments were given... Now calling the input Loop to create and test a PDA with the given inputs");
            inputLoop(pdaDescription, pdaInputStrings);
        }
        else {
            System.out.println("No / insufficient command line arguments were given... Now calling the default input Loop to create and test a PDA");
            inputLoop();
        }
        System.out.println("Now exiting... Goodbye");
    }
}
