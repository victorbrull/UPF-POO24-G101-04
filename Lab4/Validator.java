import java.util.*;

public class Validator {
    private Logo logo;

    // Constructor initializes the Validator with a Logo object.
    public Validator(Logo initLogo) {
        logo = initLogo;
    }

    // Method that returns if a Statement is valid
    public int errorCode(Statement initStatement) {
        // Return 1 if the instruction word is not recognized.
        if (!logo.getInstructions().containsKey(initStatement.getWord())) {
            return 1;
        }
        // Return 2 if the parameter is out of the valid range.
        else if (!logo.getInstruction(initStatement.getWord()).isParameterValid(initStatement.getParameter())) {
             return 2;
        }
        // Return 0 is the Statement is valid
        return 0;
    }

    // Method to print a specific error message based on Statement's error code.
    public void printError(Statement initStatement) {
        switch (errorCode(initStatement)) {
            case 1:
                System.out.println("The instruction " + initStatement.getWord() + "is not valid.");
                break;
            
            case 2:
                System.out.println("The parameter " + initStatement.getParameter() + "is out of range.");
                break;
        
            case 0:
                System.out.println("The statement is legal.");
                break;
        }
    }

    // Method that returns if a Program is valid
    public int errorCode(Program initProgram) {
        Stack<Statement> stack = new Stack<>();

        // Loop through each statement in the program.
        for (Statement tempStatement : initProgram.getBody()) {
            // Return -1 if any statement is illegal.
            if (errorCode(tempStatement) != 0) {
                return -1;
            }
            else {
                // Push "REP" statements to the stack.
                if (tempStatement.getWord() == "REP") {
                    stack.push(tempStatement);
                }
                else {
                    // If "END" is found without a matching "REP", return 1.
                    if (tempStatement.getWord() == "END" && stack.empty()) {
                        return 1;
                    }
                    else {
                        // Pop stack if "END" has a matching "REP".
                        if (tempStatement.getWord() == "END") {
                            stack.pop();
                        }
                    }
                }
            }
        }
        // Return 1 if there are unmatched "REP" statements, otherwise return 0.
        if (!stack.empty()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    // Method to print a specific error message based on Program's error code.
    public void printError(Program initProgram) {
        switch (errorCode(initProgram)) {
            case -1:
                System.out.println("There's at least one illegal statement.");
                break;
            
            case 1:
                System.out.println("There's at least one imbalanced loop.");
                break;
        
            case 0:
                System.out.println("The program is legal.");
                break;
        }
    }
}
