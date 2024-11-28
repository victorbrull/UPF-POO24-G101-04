#ifndef INSTRUCTION
#define INSTRUCTION

#include <string>
class Instruction {
protected:
    std::string name;

public:
    Instruction(const std::string &name) : name(name) {}
    virtual ~Instruction() = default;

    virtual std::string toString() const = 0;
    
    virtual void execute() = 0;
};


#endif
