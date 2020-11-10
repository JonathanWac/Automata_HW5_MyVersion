import java.io.*;
import java.util.*;

public class PDA
{

    private String PDAInfoFile, inputFile;

    private int numStates, numTransitions, numInputs;
    private String startState, finalState;
    private char inputAlphabet, popSymbol, pushSymbol;

    private LinkedList<PDA_State> pdaStates = new LinkedList<>();
    private LinkedList<LinkedList<String> > transitionsList = new LinkedList<>();
    private LinkedList<String> inputList = new LinkedList<>();
    //private Stack<String> stack = new Stack<>();

    public PDA(String PDAInfoFile, String inputFile) {
        this.PDAInfoFile = PDAInfoFile;
        this.inputFile = inputFile;
    }

    public void run()
    {
        readTransitionList();
        readInputList();

        for (String s : inputList){
            System.out.printf("Input string %s is %b\n", s, checkString(s));
            //checkString(s);
        }
    }


    boolean checkTransition(PDA_State currentState, String remainingString, Stack<Character> currentStack){

        // remainingString is not empty, so if it has the same transInput
        //      we need to recursively call -the first character of remaining string
        if (remainingString.length()>0){
            char currChar = remainingString.charAt(0);
            if (currChar == currentState.transitionInput){
                if (currentStack.size() > 0){
                    //Current stack is non empty, but popInput is epsilon
                    if (currentState.popInput == 'e'){
                        if (currentState.pushInput == 'e')
                            ;
                            //The pushInput is non e, so we push it onto stack
                        else {
                            currentStack.push(currentState.pushInput);
                        }
                        LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                        boolean bool = false;
                        for (PDA_State states : foundStates){
                            bool = (bool || checkTransition(states, remainingString.substring(1), currentStack));
                        }
                        return bool;
                    }
                    else {
                        char popChar = currentStack.pop();

                        if (popChar == currentState.popInput){
                            if (currentState.pushInput == 'e')
                                ;
                                //The pushInput is non e, so we push it onto stack
                            else {
                                currentStack.push(currentState.pushInput);
                            }
                            LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                            boolean bool = false;
                            for (PDA_State states : foundStates){
                                bool = (bool || checkTransition(states, remainingString.substring(1), currentStack));
                            }
                            return bool;
                        }
                    }
                }
                //Current stack is empty
                else {
                    //Current stack is empty but the current popInput is e
                    if (currentState.popInput == 'e'){
                        if (currentState.pushInput == 'e')
                            ;
                        else {
                            currentStack.push(currentState.pushInput);
                        }
                        LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                        boolean bool = false;
                        for (PDA_State states : foundStates){
                            bool = (bool || checkTransition(states, remainingString.substring(1), currentStack));
                        }
                        return bool;
                    }
                }
            }
            // full string, but an empty / free transition
            else if (currentState.transitionInput == 'e'){
                if (currentStack.size()>0){
                    if (currentState.popInput == 'e'){
                        if (currentState.pushInput == 'e'){
                            ;
                        }
                        else {
                            currentStack.push(currentState.pushInput);
                        }
                        LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                        boolean bool = false;
                        for (PDA_State states : foundStates){
                            bool = (bool || checkTransition(states, remainingString, currentStack));
                        }
                        return bool;
                    }
                    //a non empty stack and a non free transition
                    else{
                        char popChar = currentStack.pop();
                        if (popChar == currentState.popInput){
                            if (currentState.pushInput == 'e')
                                ;
                                //The pushInput is non e, so we push it onto stack
                            else {
                                currentStack.push(currentState.pushInput);
                            }
                            LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                            boolean bool = false;
                            for (PDA_State states : foundStates){
                                bool = (bool || checkTransition(states, remainingString, currentStack));
                            }
                            return bool;
                        }
                    }
                }
                //free transition and an empty stack
                else {
                    if (currentState.popInput == 'e'){
                        if (currentState.pushInput == 'e'){

                        }
                        else {
                            currentStack.push(currentState.pushInput);
                        }
                        LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                        boolean bool = false;
                        for (PDA_State states : foundStates){
                            bool = (bool || checkTransition(states, remainingString, currentStack));
                        }
                        return bool;
                    }
                }
            }
        }
        // The input string is empty, so check if the current state allows an empty transition
        //
        else {
            //Empty input, and at final state, and stack is empty
            if (currentState.nextStateName.equals(finalState) && currentStack.isEmpty())
                return true;

            if (currentState.transitionInput == 'e'){
                if (currentStack.size() > 0){
                    if (currentState.popInput == 'e'){
                        if (currentState.pushInput == 'e')
                            ;
                            //The pushInput is non e, so we push it onto stack
                        else {
                            currentStack.push(currentState.pushInput);
                        }
                        LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                        boolean bool = false;
                        for (PDA_State states : foundStates){
                            bool = (bool || checkTransition(states, remainingString, currentStack));
                        }
                        return bool;
                    }
                    else {
                        char popChar = currentStack.pop();
                        if (popChar == currentState.popInput){
                            if (currentState.pushInput == 'e')
                                ;
                                //The pushInput is non e, so we push it onto stack
                            else {
                                currentStack.push(currentState.pushInput);
                            }
                            if (currentStack.isEmpty() && currentState.nextStateName.equals(finalState))
                                return true;
                            LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                            boolean bool = false;
                            for (PDA_State states : foundStates){
                                bool = (bool || checkTransition(states, remainingString, currentStack));
                            }
                            return bool;
                        }
                    }
                }
                //Stack is empty
                else {
                    //Stack is empty and the popInput is empty, so continue
                    if (currentState.popInput == 'e'){
                        if (currentState.pushInput == 'e')
                            ;
                            //The pushInput is non e, so we push it onto stack
                        else {
                            currentStack.push(currentState.pushInput);
                        }
                        LinkedList<PDA_State> foundStates = findStates(currentState.nextStateName);
                        boolean bool = false;
                        for (PDA_State states : foundStates){
                            bool = (bool || checkTransition(states, remainingString, currentStack));
                        }
                        return bool;
                    }
                }
            }
            //Empty inputString, and non e transitionInput, so false
            else {
                return false;
            }
        }
        return false;
        //  Ex.
        //  q2 = currentStateName
        //  q2 (also) = nextStateName
        //  b -> a, e
        //  b = transitionInput
        //  a = popInput
        //  e = pushInput
        //
        // Pseudo-Code
        //  Check the transitionInput and compare it to the first Char of the remainingString
        //      If transitionInput == currChar,
        //          then pop the stack and check if it equals popInput
        //          (check for e)
        //          pushInput onto stack
        //          (check for e)
        //          Execute the bool for loop and at the end return bool after the bool || recursiveCall result
        //      Else
        //          Return False
        //
        //
    }

    LinkedList<PDA_State> findStates(String startState){

        LinkedList<PDA_State> foundStates = new LinkedList<>();
        for (PDA_State state : pdaStates) {
            if (state.currentStateName.equals(startState)) {
                foundStates.add(state);
            }
        }
        return foundStates;
    }
    //
    //
    //This is the only function that needs to be done
    //
    //
    boolean checkString(String inString){
        String currentState = startState, nextState;
        LinkedList<PDA_State> foundStates = findStates(startState);

        boolean bool = false;
        for (PDA_State states : foundStates){
            bool = (bool || checkTransition(states, inString, new Stack<>()));
        }
        return bool;
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
            int lineNum = 0;
            Vector<String> tokensVector = removeEmptyStrings(scanner.nextLine().split("\\s+"));
            lineNum++;

            numStates = Integer.parseInt(tokensVector.get(0));
            numTransitions = Integer.parseInt(tokensVector.get(1));
            startState = tokensVector.get(2);
            finalState = tokensVector.get(3);

            int transitionListPos = 0;
            while (transitionListPos < numTransitions){
                tokensVector = removeEmptyStrings(scanner.nextLine().split("\\s+"));
                lineNum++;
                if (tokensVector.size() != 5)
                    System.err.printf("An error occurred... The amount of tokens at line %d in fileName '%s' is something other than 5..." +
                            "\n\tThe tokens list was %s", lineNum, inputFile,tokensVector);

                transitionsList.add(new LinkedList<>());

                transitionsList.get(transitionListPos).add(tokensVector.get(0));
                transitionsList.get(transitionListPos).add(tokensVector.get(1));
                transitionsList.get(transitionListPos).add(tokensVector.get(2));
                transitionsList.get(transitionListPos).add(tokensVector.get(3));
                transitionsList.get(transitionListPos).add(tokensVector.get(4));

                if (tokensVector.get(2).length() > 1)
                    System.err.printf("An error occurred... A transition input at line %d in fileName '%s' is more than 1 character..." +
                            "\n\tThe transition input was %s", lineNum, inputFile,tokensVector.get(2));
                if (tokensVector.get(3).length() > 1)
                    System.err.printf("An error occurred... A transition input at line %d in fileName '%s' is more than 1 character..." +
                            "\n\tThe transition input was %s", lineNum, inputFile,tokensVector.get(3));
                if (tokensVector.get(4).length() > 1)
                    System.err.printf("An error occurred... A transition input at line %d in fileName '%s' is more than 1 character long..." +
                            "\n\tThe transition input was %s", lineNum, inputFile,tokensVector.get(4));

                pdaStates.add(new PDA_State(tokensVector.get(0), tokensVector.get(1), tokensVector.get(2).charAt(0), tokensVector.get(3).charAt(0), tokensVector.get(4).charAt(0)));

                transitionListPos++;
            }

            //So, according to the logic of my code, this should be safe. If a state reaches the final transition state and its
            if (findStates(finalState).isEmpty())
                ;//pdaStates.add(new PDA_State(finalState, null, 'e', 'e', 'e'));

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