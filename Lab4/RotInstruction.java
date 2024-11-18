public class RotInstruction extends TurtleInstruction{
    
    // Constructor that initializes RotInstruction by calling the TurtleInstruction constructor
    public RotInstruction(String word, int minRange, int maxRange, Turtle turtle) {
        super(word, minRange, maxRange, turtle);
    }

    // Override the apply method to obtain the desired effect
    @Override
    public void apply(int parameter) {
        // Print a message indicating the turtle's action
        System.out.println("Rotate the turtle " + parameter + " degrees");
        // Rotate the turtle by the specific parameter
        turtle.rotate(parameter);
    }
}
