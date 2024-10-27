import java.util.*;

public class Validator {
    private Logo logo;

    Validator(Logo initLogo) {
        logo = initLogo;
    }

    public int errorCode(Statement initStatement) {
        if (!logo.getInstructions().containsKey(initStatement.getWord())) {
            return 1;
        }
        else if (!logo.getInstruction(initStatement.getWord()).isParameterValid(initStatement.getParameter())) {
             return 2;
        }
        return 0;
    }

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

    public int errorCode(Program initProgram) {
        Stack<Statement> stack = new Stack<>();
        for (Statement tempStatement : initProgram.getBody()) {
            if (errorCode(tempStatement) != 0) {
                return -1;
            }
            else {
                if (tempStatement.getWord() == "REP") {
                    stack.push(tempStatement);
                }
                else {
                    if (stack.empty()) {
                        return 1;
                    }
                    else {
                        if (tempStatement.getWord() == "END") {
                            stack.pop();
                        }
                    }
                }
            }
        }
        if (!stack.empty()) {
            return 1;
        }
        else {
            return 0;
        }
    }
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
