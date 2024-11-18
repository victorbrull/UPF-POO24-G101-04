public class PenInstruction extends TurtleInstruction{
    
    // Constructor that initializes PenInstruction by calling the TurtleInstruction constructor
    public PenInstruction(String word, int minRange, int maxRange, Turtle turtle) {
        super(word, minRange, maxRange, turtle);
    }

    // Override the apply method to obtain the desired effect
    @Override
    public void apply(int parameter) {
        // Set the turtle's pen depending on the parameter
        if (parameter == 0) {
            // Print a message indicating the turtle's action
            System.out.println("Deactivate the pen");
            turtle.setPen(0);
        } else {
            // Print a message indicating the turtle's action
            System.out.println("Activate the pen");
            turtle.setPen(1);
        }
    }
}
