#ifndef FUNCTION_H
#define FUNCTION_H

#include "Instruction.h"
#include "Program.h"

class Function : public Instruction {
private:
    Program* associatedProgram;

public:
    Function(const std::string& initWord, Program* program)
        : Instruction(initWord), associatedProgram(program) {}

    Program* getProgram() const {
        return associatedProgram;
    }
};

#endif