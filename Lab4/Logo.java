import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;

public class Logo extends JPanel{
    private Turtle turtle;  // Instance of a turtle
    private HashMap <String, Instruction> instructions;  // Dictionary of instructions
    private ArrayList<Segment> segments;    // List of Segment objects

    public Logo() {
        turtle = new Turtle();   // Initialize a Turtle object
        instructions = new HashMap<>();   // Initialize an empty dictionary

        // Declare some instructions and put them into the dictionary
        // Initialize the turtle instructions with the subclass corresponent 
        instructions.put("PEN", new PenInstruction("PEN", 0, 1, turtle));
        instructions.put("FWD", new FwdInstruction("FWD", 1, 500, turtle));
        instructions.put("ROT", new RotInstruction("ROT", 1, 360, turtle));
        instructions.put("REP", new Instruction("REP", 1, 100));
        instructions.put("END", new Instruction("END"));

        // Set background's dimension and colour
        setPreferredSize(new java.awt.Dimension(1000, 1000));
        setBackground(new java.awt.Color(255, 255, 255));
    }

    // Return the Instruction of a given key
    public Instruction getInstruction(String initWord) {
        return instructions.get(initWord.toUpperCase());
    }

    // Return the dictionary of instructions
    public HashMap<String, Instruction> getInstructions() {
        return instructions;
    }

    // Method to add a function to the dictionary
    public void addFunction(String name, Program program) {
        // Create a new instance of Function
        Function function = new Function(name, program);
        // Add it to the dictionary
        instructions.put(name, function);
    }

    // Method to get the Turtle object
    public Turtle getTurtle() {
        return turtle;
    }

    // Given a set of coordinates, create a new Segment object and add it to the list
    public void addSegment(int startX, int startY, int endX, int endY) {
        Segment segment = new Segment(startX, startY, endX, endY);
        segments.add(segment);
    }

    // Override the method paint from JPanel
    @Override
    public void paint(Graphics graphic) {
        // Call the parent method
        super.paint(graphic);

        // Paint all line segments in the list
        while (segments.getFirst() != null) {
            // Paint line segment
            segments.getFirst().paint(graphic);

            // Remove the first Segment of the list
            segments.removeFirst();
        }

        // Paint the turtle
        turtle.paint(graphic);
    }
}
