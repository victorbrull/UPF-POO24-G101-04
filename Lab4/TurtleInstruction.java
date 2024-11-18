public abstract class TurtleInstruction extends Instruction{

    // Variable to hold a Turtle object
    protected Turtle turtle;  // Now, changed to protected to be able to be seen in the subclass

    // Constructor to set a TurtleInstruction object
    public TurtleInstruction(String initWord, int initMinRange, int initMaxRange, Turtle initTurtle) {
        // Call the superclass constructor to set the name and the ranges 
        super(initWord, initMinRange, initMaxRange);
        turtle = initTurtle;
    }

    // Method to apply the instruction with a given parameter
    // Made it abstract to be possible to override it in the subclass
    public abstract void apply(int parameter);
}
