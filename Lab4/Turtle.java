import java.awt.Graphics;
import java.awt.Graphics2D;

public class Turtle {
    // Private attributes
    private int xPosition;  // Current x position
    private int yPosition;  // Current y position
    private int currentAngle;  // Current angle in degrees
    private boolean isPenActivated;  // Whether the pen is activated
    private Logo logo;          // Reference to Logo object

    // Constructor to initialize the turtle
    public Turtle(Logo initLogo) {
        // Set the turtle at the center of the screen
        this.xPosition = 500;
        this.yPosition = 500; 
        this.currentAngle = 0;  // Facing up (0 degrees)
        this.isPenActivated = false;  // Pen is initially deactivated
        this.logo = initLogo;
    }

    // Getter for x position
    public int getXPosition() {
        return xPosition;
    }

    // Getter for y position
    public int getYPosition() {
        return yPosition;
    }

    // Getter for the current angle
    public int getAngle() {
        return currentAngle;
    }

    // Getter for pen status
    public boolean getIsPenActivated() {
        return isPenActivated;
    }

    // Method to move the turtle forward
    public void moveForward(int distance) {
        // Update the turtle's position based on the current angle
        int endX = xPosition + (int) (distance * Math.cos(Math.toRadians(currentAngle)));
        int endY = yPosition + (int) (distance * Math.sin(Math.toRadians(currentAngle)));

        // Check if the pen is activated
        if (getIsPenActivated()) {
            // Then, add the segment from the current to the new coordinates
            logo.addSegment(xPosition, yPosition, endX, endY);
        }

        // Update the turtle's position to the new coordinates
        xPosition = endX;
        yPosition = endY;;
    }

    // Method to rotate the turtle
    public void rotate(int degrees) {
        currentAngle = (currentAngle + degrees) % 360;  // Keep the angle within 0-359 degrees
    }

    // Setter to activate the pen
    public void setPen(int penStatus) {
        if (penStatus == 0) {
            isPenActivated = false;
        } else {
            isPenActivated = true;
        }
    }

    // toString method to return a string representation of the current status of the turtle
    public String toString() {
        return "Position: (" + xPosition + ", " + yPosition + ")\nAngle: " + currentAngle + "º\nPen Active: " + isPenActivated;
    }

    // Method to draw the current position and direction of the turtle on the screen
    public void paint(Graphics graphic) {

        // Compute tip's coordinates
        int tipX = xPosition + (int) (20 * Math.cos(Math.toRadians(currentAngle)));
        int tipY = yPosition + (int) (20 * Math.sin(Math.toRadians(currentAngle)));

        // Compute the left corner's coordinates
        int leftX = xPosition + (int) (10 * Math.cos(Math.toRadians(currentAngle + 90)));
        int leftY = yPosition + (int) (10 * Math.sin(Math.toRadians(currentAngle + 90)));

        // Compute the right corner's coordinates
        int rightX = xPosition + (int) (10 * Math.cos(Math.toRadians(currentAngle + 270)));
        int rightY = yPosition + (int) (10 * Math.sin(Math.toRadians(currentAngle + 270)));

        // Paint the three segments of the triangle given the previuos points
        // Declare the segments
        Segment s1 = new Segment(leftX, leftY, rightX, rightY);
        Segment s2 = new Segment(leftX, leftY, tipX, tipY);
        Segment s3 = new Segment(tipX, tipY, rightX, rightY);

        // Paint the segments
        s1.paint(graphic);
        s2.paint(graphic);
        s3.paint(graphic);
    }
}
