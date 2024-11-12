public class TestLogo {
    public static void main(String[] args) {
        Logo logo = new Logo();

        Program program = new Program();
        program.addStatement("REP", 2);
        program.addStatement("ROT", 50);
        program.addStatement("REP", 3);
        program.addStatement("FWD", 50);
        program.addStatement("END");
        program.addStatement("ROT", 50);
        program.addStatement("END");

        Turtle turtle = new Turtle();
        /*
        TurtleInstruction hex = new TurtleInstruction("HEX", 0, 500, turtle);
        
        logo.addFunction("HEX", program);
        program.addStatement("HEX");
         */
        Interpreter interpreter = new Interpreter(logo, program);
        interpreter.run();
    }
}
