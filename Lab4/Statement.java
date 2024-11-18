public class Statement {

    // Variables of a Statement object
    private String word;
    private int parameter;

    // Constructor to create a Statement with a given parameter
    public Statement(String initWord, int initParameter) {
        // Check if the word is made of 3 characters
        if (initWord.length() == 3) {
            word = initWord.toUpperCase();
        }        
        parameter = initParameter;
    }

    // Constructor to create a Statement with a given parameter
    public Statement(String initWord) {
        // Check if the word is made of 3 characters
        if (initWord.length() == 3) {
            word = initWord.toUpperCase();
        }        
    }

    // Getters that return the variables of a Statement
    public String getWord() {
        return word;
    }

    public int getParameter() {
        return parameter;
    }

    // Method that returns the Statement as a unique string
    public String toString() {
        if (parameter != 0) {
            return "Statement: " + word + "\nParameter: " + parameter;
        } else {
            return "Statement: " + word + "\nNo parameter";
        }
    }
    
}
