import java.awt.Graphics;

public class Segment {
    
    // Starting and ending coordinates of the segment
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    // Constructor to set the coordinates
    public Segment(int x1, int y1, int x2, int y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
    }

    // Given the coordinates draw a line from the starting to the ending point
    public void paint(Graphics graphic) {
        graphic.drawLine(startX, startY, endX, endY);
    }
}
