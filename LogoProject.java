public class LogoProject {
    public static void main(String[] args) {
        Instruction moveForwardInstruction = new Instruction("FRW", 1, 500);
        System.out.println(moveForwardInstruction);
        System.out.println("Is 1 in range? " + moveForwardInstruction.isParameterValid(1));
        System.out.println("Is 2 in range? " + moveForwardInstruction.isParameterValid(512)); // Should be false

    }
}
