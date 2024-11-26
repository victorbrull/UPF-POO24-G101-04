public class TestLogo {
    public static void main(String[] args) {
        // Code to check if the new implemented classes work propertly
        
        // Crate a new Program object
        Program p1 = new Program();
        p1.addStatement("PEN", 1);
        p1.addStatement("REP", 10);
        p1.addStatement("FWD", 100);
        p1.addStatement("ROT", 10);
        p1.addStatement("END" );
        p1.addStatement("PEN", 0);



        // Initialize an instance of a Logo object
        Logo logo = new Logo();

        // Create the Interpreter which should execute p2
        Interpreter interpreter = new Interpreter(logo, p1);
        interpreter.run();

        // Display the resulting drawing
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setContentPane( logo );
        frame.pack();
        frame.setDefaultCloseOperation( javax.swing.JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
}