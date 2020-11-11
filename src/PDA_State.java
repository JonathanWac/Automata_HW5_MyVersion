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
