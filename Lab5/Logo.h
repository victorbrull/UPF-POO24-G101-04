#ifndef LOGO
#define LOGO

#include "Instruction.h"
#include "Turtle.h"
#include <map>

class Logo {
private:
    Turtle turtle;
    std::map<std::string, Instruction*> instructions;

public:
    void addInstruction(const std::string &name, Instruction *instr) {
        instructions[name] = instr;
    }

    void execute(const std::string &name) {
        if (instructions.find(name) != instructions.end()) {
            instructions[name]->execute();
        }
    }
};

#endif
