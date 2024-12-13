#include "Program.h"
#include "Statement.h"
#include "Logo.h"
#include "TurtleInstruction.h"
#include "Function.h"
#include <iostream>
#include <stack>

int main() {
    Logo logo;

    // Define Program p1
    Program p1;
    p1.addStatement("REP", 4);
    p1.addStatement("FWD", 200);
    p1.addStatement("ROT", 90);
    p1.addStatement("END");

    // Define Program p2
    Program p2;
    p2.addStatement("REP", 6);
    p2.addStatement("FWD", 100);
    p2.addStatement("ROT", 60);
    p2.addStatement("END");

    // Define Program p3
    Program p3;
    p3.addStatement("PEN", 1);
    p3.addStatement("REP", 3);
    p3.addStatement("SQR");
    p3.addStatement("HEX");
    p3.addStatement("FWD", 100);
    p3.addStatement("ROT", 30);
    p3.addStatement("END");

    // Add custom functions to Logo
    logo.addFunction("FUNC1", &p1);
    logo.addFunction("FUNC2", &p2);

    // Execute instructions in p3
    std::stack<int> loopStack;
    for (int i = 0; i < p3.getSize(); ++i) {
        Statement* stmt = p3.getStatement(i);
        Instruction* instr = logo.getInstruction(stmt->getWord());

        if (stmt->getWord() == "REP") {
            loopStack.push(i);
        } else if (stmt->getWord() == "END" && !loopStack.empty()) {
            int loopStart = loopStack.top();
            Statement* loopStmt = p3.getStatement(loopStart);
            int repetitions = loopStmt->getParam();

            static int currentReps = 0;
            if (currentReps < repetitions - 1) {
                currentReps++;
                i = loopStart; // Jump back to the start of the loop
            } else {
                currentReps = 0;
                loopStack.pop(); // Exit the loop
            }
        } else if (instr) {
            if (TurtleInstruction* tInstr = dynamic_cast<TurtleInstruction*>(instr)) {
                tInstr->apply(stmt->getParam());
            } else if (Function* func = dynamic_cast<Function*>(instr)) {
                Program* funcProgram = func->getProgram();
                for (int j = 0; j < funcProgram->getSize(); ++j) {
                    Statement* funcStmt = funcProgram->getStatement(j);
                    Instruction* funcInstr = logo.getInstruction(funcStmt->getWord());
                    if (TurtleInstruction* funcTInstr = dynamic_cast<TurtleInstruction*>(funcInstr)) {
                        funcTInstr->apply(funcStmt->getParam());
                    }
                }
            }
        } else {
            std::cout << "Unknown instruction: " << stmt->getWord() << std::endl;
        }
    }

    // Output the turtle's final state
    std::cout << "Final Turtle State: " << logo.getTurtle().toString() << std::endl;

    return 0;
}