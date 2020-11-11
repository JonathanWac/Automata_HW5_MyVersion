///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  Jonathan Wachholz
//      HW 5
//      Main.java
//      jhw190002
//      Nov. 10th 2020
//      CS 4384.502 Automata Theory
//      Prof. Stallbohm
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// PDA Description input format:
//      The input will consist of a number of lines.
//      The first line consist of the description of the PDA,
//  The first number n the number of states, second number t the number of transitions, third
//  number s is the start state and the last numbers separated by a comma are the final states.
//    First line ex:  num_states num_transitions start_state final_states
//
//  There will be t lines following the first describing each transition. The first symbol q is the
//start state, second symbol q’ is the end state, third symbol sigma is the alphabet letter for
//the transition, fourth symbol pop_symbol is the stack symbol being popped onto the stack, and fifth
//symbol push_symbol is the symbol being pushed onto the stack.
//
//      next T lines ex: current_state next_state input_alphabet pop_symbol push_symbol
//
//  Assumptions made:
//      1. The test Strings Input file does not contain any inputs with the lowercase letter e
//      2. The PDA Descriptions file will always be structured as described above
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  The test strings input
//      The input for the test strings file will consist of a number of lines. The first line is a number,
//  n, which is the number of test inputs to follow. The next n lines contain a test string to feed
//  as input into your PDA
//
//      ex. (a test file with 2 inputs)
//          2
//          aabbbbbb
//          ba
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

            System.out.println("\nPlease enter a filename from which to import the next PDA description: ");
            pdaDescrFile = scanner.next();
            if (pdaDescrFile.toLowerCase().equals("exit"))
                break;
            System.out.println("Please enter a filename from which to import the next input strings to be tested by the PDA: ");
            pdaTestStringsFile = scanner.next();
        }
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
            System.out.println("\nPlease enter a filename from which to import the next PDA description: ");
            pdaDescrFile = scanner.next();
            if (pdaDescrFile.toLowerCase().equals("exit"))
                break;
            System.out.println("Please enter a filename from which to import the next input strings to be tested by the PDA: ");
            pdaTestStringsFile = scanner.next();
        }
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
            System.out.println("2 command line arguments were given... Now calling the input Loop to create and test a PDA with the given inputs\n");
            inputLoop(pdaDescription, pdaInputStrings);
        }
        else {
            System.out.println("No / insufficient command line arguments were given... Now calling the default input Loop to create and test a PDA\n");
            inputLoop();
        }


        //Uncomment this to quickly run the input files, assuming they are accessible in the current directory
/*      System.out.println("\nInput 1");
        PDA pda = new PDA("input1.txt", "testInput1.txt");
        pda.run();
        System.out.println("\nInput 2");
        PDA pda1 = new PDA("input2.txt", "testInput2.txt");
        pda1.run();
        System.out.println("Now exiting the program... Goodbye");*/
    }
}
