#ifndef LOGO_H
#define LOGO_H

#include "Turtle.h"
#include "Instruction.h"
#include "TurtleInstruction.h"
#include "Function.h"
#include <map>

class Logo {
private:
    Turtle turtle;
    std::map<std::string, Instruction*> instructions;

public:
    Logo() {
        instructions["PEN"] = new TurtleInstruction("PEN", 0, 1, &turtle);
        instructions["FWD"] = new TurtleInstruction("FWD", 1, 500, &turtle);
        instructions["ROT"] = new TurtleInstruction("ROT", 1, 360, &turtle);
        instructions["REP"] = new Instruction("REP", 1, 100);
        instructions["END"] = new Instruction("END");
    }

    ~Logo() {
        for (auto& pair : instructions) {
            delete pair.second;
        }
    }

    Instruction* getInstruction(const std::string& word) {
        auto it = instructions.find(word);
        return it != instructions.end() ? it->second : nullptr;
    }

    void addFunction(const std::string& name, Program* program) {
        instructions[name] = new Function(name, program);
    }

    Turtle& getTurtle() {
        return turtle;
    }
};

#endif
