public class FwdInstruction extends TurtleInstruction{
    
    // Constructor that initializes FwdInstruction by calling the TurtleInstruction constructor
    public FwdInstruction(String word, int minRange, int maxRange, Turtle turtle) {
        super(word, minRange, maxRange, turtle);
    }
    
    // Override the apply method to obtain the desired effect
    @Override
    public void apply(int parameter) {
        // Print a message indicating the turtle's action
        System.out.println("Move the turtle " + parameter + " units forward");
        // Move the turtle by the specific parameter
        turtle.moveForward(parameter);
    }
}
