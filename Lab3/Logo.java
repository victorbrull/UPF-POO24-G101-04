import java.util.*;

public class Logo {
    private Turtle turtle;  // Instance of a turtle
    private HashMap <String, Instruction> instructions;  // Dictionary of instructions

    public Logo() {
        turtle = new Turtle();   // Initialize a Turtle object
        instructions = new HashMap<>();   // Initialize an empty dictionary

        // Declare some instructions and put them into the dictionary
        instructions.put("PEN", new Instruction("PEN", 0, 1));
        instructions.put("FWD", new Instruction("FWD", 1, 500));
        instructions.put("ROT", new Instruction("ROT", 1, 360));
        instructions.put("REP", new Instruction("REP", 1, 100));
        instructions.put("END", new Instruction("END"));
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
}
