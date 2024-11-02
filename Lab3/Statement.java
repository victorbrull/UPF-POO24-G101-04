public class Statement {
    private String word;
    private int parameter;

    public Statement(String initWord, int initParameter) {
        if (initWord.length() == 3) {
            word = initWord.toUpperCase();
        }        
        parameter = initParameter;
    }

    public Statement(String initWord) {
        if (initWord.length() == 3) {
            word = initWord.toUpperCase();
        }        
    }

    public String getWord() {
        return word;
    }

    public int getParameter() {
        return parameter;
    }

    public String toString() {
        if (parameter != 0) {
            return "Statement: " + word + "\nParameter: " + parameter;
        } else {
            return "Statement: " + word + "\nNo parameter";
        }
    }
    
}
