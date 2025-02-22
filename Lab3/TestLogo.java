public class TestLogo {
    public static void main(String[] args) {
        // Code to check if the new implemented classes work propertly
        
        // Crate a new Program object
        Program p1 = new Program();
        // Add a list of statements to the p1
        p1.addStatement("REP", 3);
        p1.addStatement("FWD", 100);
        p1.addStatement("ROT", 50);
        p1.addStatement("END");

        // Initialize an instance of a Logo object
        Logo logo = new Logo();

        // Add p1 as a Function with name "ABC" 
        logo.addFunction("ABC", p1);
        // Create another Program
        Program p2 = new Program();
        p2.addStatement("PEN", 1);
        p2.addStatement("REP", 1);
        p2.addStatement("ABC");
        p1.addStatement("ROT", 40);
        p2.addStatement("FWD", 20);
        p2.addStatement("END");
        p2.addStatement("PEN", 0);

        // Create the Interpreter which should execute p2
        Interpreter interpreter = new Interpreter(logo, p2);
        interpreter.run();
    }
}