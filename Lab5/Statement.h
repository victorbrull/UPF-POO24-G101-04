
#ifndef STATEMENT
#define STATEMENT

#include <sstream>

class Statement {

private:

    std::string word;
    int param;
    
public:
    
    Statement( const std::string & w, int p )
        : word( w ), param( p ) {
    }
    
    std::string getWord() {
        return word;
    }
    
    int getParam() {
        return param;
    }
    
    std::string toString() {
        std::stringstream ss;
        ss << word << " " << param;
        return ss.str();
    }

};

#endif

