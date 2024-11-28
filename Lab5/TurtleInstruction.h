#ifndef TURTLEINSTRUCTION
#define TURTLEINSTRUCTION

#include "Instruction.h"
#include "Turtle.h"
#include <iostream>

class TurtleInstruction : public Instruction {
private:
    Turtle *turtle;

public:
    TurtleInstruction(const std::string &name, Turtle *t) 
    : Instruction(name), turtle(t) {}

    std::string toString() const override {
        return name + ": " + turtle->toString();
    }

    void execute() {
        // Logic based on "name"
        if (name == "MoveForward") turtle->moveFwd(100);
        else if (name == "Rotate") turtle->rotate(90);

        // Prints the status of the Turtle after executing the instruction
        std::cout << "Executed " << name << ": " << turtle->toString() << std::endl;
    }
};

#endif
