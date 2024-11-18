public class Function extends Instruction {
    
    // Variable to hold a Program object
    private Program associatedProgram;

    // Constructur to set a Function
    public Function(String initWord, Program p) {
        // Call the suprclass constructor to set the name
        super(initWord);
        associatedProgram = p;
    }

    // Method to return the associated program to the Function object
    public Program getProgram() {
        return associatedProgram;
    }
}
