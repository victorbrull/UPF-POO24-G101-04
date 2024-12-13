#ifndef INSTRUCTION_H
#define INSTRUCTION_H

#include <string>
#include <sstream>

class Instruction {
protected:
    std::string word;
    int minRange;
    int maxRange;

public:
    Instruction(const std::string& initWord)
        : word(initWord), minRange(0), maxRange(0) {
        if (word.length() == 3) {
            for (char& c : word) c = toupper(c);
        }
    }

    Instruction(const std::string& initWord, int initMinRange, int initMaxRange)
        : word(initWord), minRange(initMinRange), maxRange(initMaxRange) {
        if (word.length() == 3) {
            for (char& c : word) c = toupper(c);
        }
    }

    virtual ~Instruction() = default;

    std::string getWord() const {
        return word;
    }

    int getMinRange() const {
        return minRange;
    }

    int getMaxRange() const {
        return maxRange;
    }

    virtual std::string toString() const {
        std::stringstream ss;
        ss << "Instruction: " << word << "\nLegal range: [" << minRange << ", " << maxRange << "]";
        return ss.str();
    }

    bool isParameterValid(int userParameter) const {
        return minRange <= userParameter && userParameter <= maxRange;
    }
};

#endif