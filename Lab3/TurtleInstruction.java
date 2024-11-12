public class TurtleInstruction extends Instruction{

    // Variable to hold a Turtle object
    private Turtle turtle;

    // Constructor to set a TurtleInstruction object
    public TurtleInstruction(String initWord, Turtle initTurtle, int initMinRange, int initMaxRange) {
        // Call the superclass constructor to set the name and the ranges 
        super(initWord, initMinRange, initMaxRange);
        turtle = initTurtle;
    }

    // Method to apply the instruction with a given parameter
    public void apply(int parameter) {
        // Print the instruction name and parameter value to the screen
        System.out.println("Instruction name: " + word);
        System.out.println("Parameter value: " + parameter);
    }
}
