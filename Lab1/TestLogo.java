public class TestLogo {
    public static void main(String[] args) {
        Instruction moveForwardInstruction = new Instruction("FWD", 1, 500);
        System.out.println(moveForwardInstruction.toString());
        System.out.println("Is 1 in range? " + moveForwardInstruction.isParameterValid(1));
        System.out.println("Is 2 in range? " + moveForwardInstruction.isParameterValid(512)); // Should be false


        Turtle turtle = new Turtle();
        turtle.rotate(45);
        turtle.setPen(1);
        System.out.println(turtle.toString());
        turtle.moveForward(40);
        int x = turtle.getXPosition();
        int y = turtle.getYPosition();
        System.out.println("X position: " + x);
        System.out.println("Y position: " + y);
        System.out.println(turtle.toString());
        turtle.setPen(0);
    }
}
