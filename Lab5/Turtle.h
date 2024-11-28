
#ifndef TURTLE
#define TURTLE

#include <cmath>
#include <sstream>

class Turtle {

private:

    int pen;
    int xpos;
	int ypos;
	int angle;

public:
    
	Turtle()
	    : pen( 0 ), xpos( 0 ), ypos( 0 ), angle( 0 ) {
	    // initialization is not to 0 by default!
	}
	
	int getPen() {
	    return pen;
	}
    
	int getXpos() {
	    return xpos;
	}
    
	int getYpos() {
	    return ypos;
	}
    
	int getAngle() {
	    return angle;
	}
    
	std::string toString() {
	    std::stringstream ss;
	    ss << "(" << pen << "," << xpos << "," << ypos << "," << angle << ")";
	    return ss.str();
	}
	
	void setPen( int p ) {
	    pen = p;
	}
    
	void moveFwd( int dist ) {
	    int dx = (int)( sin( angle * M_PI / 180 ) * dist );
	    int dy = (int)( cos( angle * M_PI / 180 ) * dist );
	    xpos += dx;
	    ypos += dy;
	}
	
	void rotate( int deg ) {
	    angle = ( angle + deg ) % 360;
	}
    
};

#endif

