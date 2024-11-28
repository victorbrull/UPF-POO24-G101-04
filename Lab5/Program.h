
#ifndef PROGRAM
#define PROGRAM

#include "Statement.h"

#include <vector>

class Program {

private:

    std::vector<Statement> body;
    
public:
    
    Program() {
    }
    
    void addStatement( const std::string & w, int p ) {
        body.push_back( Statement( w, p ) );
    }
    
    void addStatement( const std::string & w ) {
        addStatement( w, 0 );
    }
    
    int getSize() {
        return body.size();
    }
    
    Statement * getStatement( int line ) {
        return &body[line];
    }

};

#endif

