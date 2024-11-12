public class Interpreter {
    
    private Logo logo;      // To get acces to the dictionary
    private Program program;   // Program to be executed
    private int line;         // Keep track in which line there is a REP instruction
    private int executedLoops;   // Keep track of the loops executed

    // Constructor method
    public Interpreter(Logo initLogo, Program initProgram) {
        logo = initLogo;
        program = initProgram;
    }

    // Method to start execution 
    public void run() {

        // Firstly, validate if the program works propertly
        Validator validator = new Validator(logo);
        if (validator.errorCode(program) != 0) {
            validator.printError(program); 

        } else {
            
            // Once the program is valid iterate over each statement of the program
            for (int i = 0; i < program.getSize(); i++) {
                switch (program.getStatement(i).getWord()) {
                    case "REP":
                        executedLoops = 0;
                        line = i;
                }
            }
        }
    }
}
