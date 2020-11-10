public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Input 1");
        PDA pda1 = new PDA("input1.txt", "testInput1.txt");
        pda1.run();
        System.out.println("\nInput 2");
        PDA pda2 = new PDA("input2.txt", "testInput2.txt");
        pda2.run();
        System.out.println("\nInput 3");
        PDA pda3 = new PDA("input3.txt", "testInput3.txt");
        pda3.run();
    }
}
