import java.util.*;

public class Program {
    private ArrayList<Statement> body;

    public Program() {
        body = new ArrayList<>();
    }

    public void addStatement(String initWord, int initParameter) {
        Statement newStatement = new Statement(initWord, initParameter);
        body.add(newStatement);
    }

    public void addStatement(String initWord) {
        Statement newStatement = new Statement(initWord);
        body.add(newStatement);
    }

    public int getSize() {
        return body.size();
    }

    public Statement getStatement(int index) {
        if (getSize() > index && index >= 0) {
            return body.get(index);
        }
        return null;
    }

    public ArrayList<Statement> getBody(){
        return body;
    }
}
