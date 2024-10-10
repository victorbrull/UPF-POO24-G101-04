public class Turtle {
    // Private attributes
    private int xPosition;  // Current x position
    private int yPosition;  // Current y position
    private int currentAngle;  // Current angle in degrees
    private boolean isPenActivated;  // Whether the pen is activated

    // Constructor to initialize the turtle
    public Turtle() {
        this.xPosition = 0;  // Starting x position
        this.yPosition = 0;  // Starting y position
        this.currentAngle = 0;  // Facing up (0 degrees)
        this.isPenActivated = false;  // Pen is initially deactivated
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
        xPosition += distance * Math.cos(Math.toRadians(currentAngle));
        yPosition += distance * Math.sin(Math.toRadians(currentAngle));
    }

    // Method to rotate the turtle
    public void rotate(int degrees) {
        currentAngle = (currentAngle + degrees % 360);  // Keep the angle within 0-359 degrees
    }

    // Setter to activate the pen
    public void setPenActive() {
        isPenActivated = true;
    }

    // Setter to deactivate the pen
    public void setPenDeactive() {
        isPenActivated = false;
    }

    // toString method to return a string representation of the current status of the turtle
    public String toString() {
        return "Position: (" + xPosition + ", " + yPosition + ")\nAngle: " + currentAngle + "º\nPen Active: " + isPenActivated;
    }
}
