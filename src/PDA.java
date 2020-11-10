import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class PDA
{

    private String PDAInfoFile, inputFile;

    private int numStates, numTransitions, startState, finalState;
    private int currentState, nextState, numInputs;
    private char inputAlphabet, popSymbol, pushSymbol;

    private LinkedList<LinkedList<String> > transitionsList = new LinkedList<>();
    private LinkedList<String> inputList = new LinkedList<>();
    private Stack<String> stack = new Stack<>();

    public PDA(String PDAInfoFile, String inputFile) {
        this.PDAInfoFile = PDAInfoFile;
        this.inputFile = inputFile;
    }

    public void run()
    {
        readTransitionList();
        readInputList();

/*        readInput(instructionsFile, transitionsList);
        readInput(inputFile, inputList);
        getRules(transitionsList);
        getInput(inputList);
        addToStack(transitionsList, inputList, stack);*/
    }

    void checkString(String inString){

    }

    void readInputList(){
        try {
            FileReader fileReader = new FileReader(inputFile);
            Scanner scanner = new Scanner(fileReader);
            Vector<String> tokensVector = removeEmptyStrings(scanner.nextLine().split("\\s+"));

            numInputs = Integer.parseInt(tokensVector.get(0));

            int inputListPos = 0;
            while (inputListPos < numInputs){
                String input = scanner.nextLine().trim();
                inputList.add(input);
                inputListPos++;
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readTransitionList(){
        try {
            FileReader fileReader = new FileReader(PDAInfoFile);
            Scanner scanner = new Scanner(fileReader);
            Vector<String> tokensVector = removeEmptyStrings(scanner.nextLine().split("\\s+"));

            numStates = Integer.parseInt(tokensVector.get(0));
            numTransitions = Integer.parseInt(tokensVector.get(1));
            startState = Integer.parseInt(tokensVector.get(2));
            finalState = Integer.parseInt(tokensVector.get(3));

            int transitionListPos = 0;
            while (transitionListPos < numTransitions){
                tokensVector = removeEmptyStrings(scanner.nextLine().split("\\s+"));
                if (tokensVector.size() != 5)
                    System.out.println("The vector is empty");
                transitionsList.add(new LinkedList<>());

                transitionsList.get(transitionListPos).add(tokensVector.get(0));
                transitionsList.get(transitionListPos).add(tokensVector.get(1));
                transitionsList.get(transitionListPos).add(tokensVector.get(2));
                transitionsList.get(transitionListPos).add(tokensVector.get(3));
                transitionsList.get(transitionListPos).add(tokensVector.get(4));

                transitionListPos++;
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Vector<String> removeEmptyStrings(String[] arr){
        Vector<String> vector = new Vector<>(arr.length);
        for (String string: arr)
            if (!string.equals("") && !string.equals(" "))
                vector.add(string);
        return vector;
    }
}