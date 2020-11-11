///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  Jonathan Wachholz
//      HW 5
//      PDA_State.java
//      jhw190002
//      Nov. 10th 2020
//      CS 4384.502 Automata Theory
//      Prof. Stallbohm
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
//      A representation of a single PDA transition state. Will contain only one transition and the required
//          transition, pop, and push Inputs for that single transition
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class PDA_State {
    //  Ex.
    //  q2 = currentStateName
    //  q2 (also) = nextStateName
    //  b -> a, e
    //  b = transitionInput
    //  a = popInput
    //  e = pushInput
    public String currentStateName, nextStateName;
    public char transitionInput, popInput, pushInput;



    public PDA_State(String currentStateName, String nextStateName, char transitionInput, char popInput, char pushInput) {
        this.currentStateName = currentStateName;
        this.nextStateName = nextStateName;
        this.transitionInput = transitionInput;
        this.popInput = popInput;
        this.pushInput = pushInput;
    }


}
