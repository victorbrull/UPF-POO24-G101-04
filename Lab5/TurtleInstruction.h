#ifndef TURTLE_INSTRUCTION_H
#define TURTLE_INSTRUCTION_H

#include "Instruction.h"
#include "Turtle.h"
#include <iostream>

class TurtleInstruction : public Instruction {
private:
    Turtle* turtle;

public:
    TurtleInstruction(const std::string& initWord, int initMinRange, int initMaxRange, Turtle* initTurtle)
        : Instruction(initWord, initMinRange, initMaxRange), turtle(initTurtle) {}

    void apply(int parameter) {
        std::cout << "Executing " << word << " with parameter " << parameter << " to the turtle." << std::endl;
        if (word == "FWD") {
            turtle->moveFwd(parameter);
        } else if (word == "ROT") {
            turtle->rotate(parameter);
        } else if (word == "PEN") {
            turtle->setPen(parameter);
        }
    }
};

#endif