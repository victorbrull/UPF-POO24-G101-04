import java.util.*;

public class Logo {
    private Turtle turtle;
    private HashMap <String, Instruction> instructions;

    Logo() {
        turtle = new Turtle();
        instructions = new HashMap<>();

        instructions.put("PEN", new Instruction("PEN", 0, 1));
        instructions.put("FWD", new Instruction("FWD", 1, 500));
        instructions.put("ROT", new Instruction("ROT", 1, 360));
        instructions.put("REP", new Instruction("REP", 1, 100));
        instructions.put("END", new Instruction("END"));
    }

    public Instruction getInstruction(String initWord) {
        return instructions.get(initWord.toUpperCase());
    }

    public HashMap<String, Instruction> getInstructions() {
        return instructions;
    }
}
