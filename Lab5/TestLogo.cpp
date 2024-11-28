#include "Logo.h"
#include "TurtleInstruction.h"
#include "Function.h"

int main() {
    Turtle turtle;
    Logo logo;

    TurtleInstruction ti1("MoveForward", &turtle);
    TurtleInstruction ti2("Rotate", &turtle);

    logo.addInstruction("FWD", &ti1);
    logo.addInstruction("ROT", &ti2);

    logo.execute("FWD");
    std::cout << "Turtle state after FWD: " << turtle.toString() << std::endl;

    logo.execute("ROT");
    std::cout << "Turtle state after ROT: " << turtle.toString() << std::endl;

    return 0;
}
