
import java.util.*;

public class Interpreter {
    
    private Logo logo;      // To get acces to the dictionary
    private Program program;   // Program to be executed
    private int line;         // Keep track of the current line

    // Constructor method
    public Interpreter(Logo initLogo, Program initProgram) {
        logo = initLogo;
        program = initProgram;
        line = 0;
    }

    // Method to start execution 
    public void run() {

        // Firstly, validate whether the program works propertly
        Validator validator = new Validator(logo);
        if (validator.errorCode(program) != 0) {
            validator.printError(program); 

        } else {
            // Once the program is valid iterate over each statement of the program
            Stack<Integer> stack = new Stack<>(); // Create a stack to store the line number of each REP
            ArrayList<ArrayList<Integer>> executedLoopsArrayList2D = new ArrayList<>(); // Create an ArrayList2D to keep track of the number of executed loops of each loop 
            while (line < program.getSize()) {
                Statement currentStatement = program.getStatement(line);

                if (currentStatement.getWord().equals("REP")) {
                    // In case of REP, we add a new row to the ArrayList2D with two elements: 
                    // the line number of the begginig of the loop, and the number of times that loop has been exeuted
                    stack.push(line);
                    ArrayList<Integer> newRow = new ArrayList<>();
                    newRow.add(line);
                    newRow.add(0);
                    executedLoopsArrayList2D.add(newRow);
                }

                else if (currentStatement.getWord().equals("END")) {
                    // In case of END, we add 1 to the number of executed loops of that exactly loop
                    int indexRow = -1;
                    for (indexRow = 0; indexRow < executedLoopsArrayList2D.size(); indexRow++) {
                        if (executedLoopsArrayList2D.get(indexRow).get(0) == stack.peek()) {
                            int temp = executedLoopsArrayList2D.get(indexRow).get(1);
                            temp++;
                            executedLoopsArrayList2D.get(indexRow).set(1, temp);
                            break;
                        }
                    }
                    // Then, if the number of executed loops is still less than the parameter of that loop, return at the beggining of that loop 
                    if (executedLoopsArrayList2D.get(indexRow).get(1) < program.getStatement(stack.peek()).getParameter()) {
                        line = stack.peek();
                    }
                    // However, if the nuber of executed loops equals to the parameter of that loop, it means that that loop has already been completed, so we pop its beggining line and its loops counter
                    else {
                        stack.pop();
                        executedLoopsArrayList2D.remove(indexRow);
                    }
                }

                else if (logo.getInstruction(currentStatement.getWord()) instanceof TurtleInstruction) {
                    // Downcast to TurtleInstruction to access the apply method
                    TurtleInstruction turtleInstruction = (TurtleInstruction) logo.getInstruction(currentStatement.getWord());
                    // Call the apply method with the appropriate parameter
                    turtleInstruction.apply(currentStatement.getParameter());
                }
                
                else if (logo.getInstruction(currentStatement.getWord()) instanceof Function) {
                    // Downcasting the current statement so it corresponds to a Function
                    Function function = (Function) logo.getInstruction(currentStatement.getWord());
                    Program associatedProgram = function.getProgram();
                        
                    Interpreter interpreter = new Interpreter(logo, associatedProgram);
                    interpreter.run(); // Recursively run the associated program
                }

                line++;
            }
        }
    } 
}
