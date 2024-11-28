#ifndef FUNCTION
#define FUNCTION

#include "Instruction.h"
#include "Program.h"

class Function : public Instruction {
private:
    Program *program;

public:
    Function(const std::string &name, Program *p) 
        : Instruction(name), program(p) {}

    std::string toString() const override {
        return name + ": Program size = " + std::to_string(program->getSize());
    }

    void execute() override {
        for (int i = 0; i < program->getSize(); ++i) {
            program->getStatement(i)->toString(); 
        }
    }
};

#endif
