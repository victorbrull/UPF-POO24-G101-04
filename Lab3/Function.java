public class Function extends Instruction {
    
    private Program associatedProgram;

    public Function(String initWord, int initMinRange, int initMaxRange, Program p) {
        super(initWord, initMinRange, initMaxRange);
        associatedProgram = p;
    }

    public Program getProgram() {
        return associatedProgram;
    }
}
