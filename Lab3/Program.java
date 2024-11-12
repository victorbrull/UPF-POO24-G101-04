import java.util.*;

public class Program {
    private ArrayList<Statement> body;  // List of statements

    public Program() {
        body = new ArrayList<>();  // Initialize an empty list
    }

    // Method to add a Statement object to the list
    public void addStatement(String initWord, int initParameter) {
        // Given a string and a parameter, create a Statement
        Statement newStatement = new Statement(initWord, initParameter);
        // Add it to the list
        body.add(newStatement);
    }

    // Method to add a Statement without parameter
    public void addStatement(String initWord) {
        Statement newStatement = new Statement(initWord);
        body.add(newStatement);
    }

    // Return the size of the array
    public int getSize() {
        return body.size();
    }

    // Return the Statement of the given index   
    public Statement getStatement(int index) {
        if (getSize() > index && index >= 0) {
            return body.get(index);
        }
        return null;
    }

    // Method to get the array of statements
    public ArrayList<Statement> getBody(){
        return body;
    }
}
