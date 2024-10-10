public class Instruction {
    private String word;
    private int minRange;
    private int maxRange;

    // Constructor for instructions without range
    public Instruction(String initWord) {
        if (initWord.length() == 3) {
            word = initWord.toUpperCase();
        }
    }

    // Constructor for instructions within a certain range
    public Instruction(String initWord, int initMinRange, int initMaxRange) {
        if (initWord.length() == 3) {
            word = initWord.toUpperCase();
        }

        if (initMinRange < initMaxRange) {
            minRange = initMinRange;
            maxRange = initMaxRange;
        }
    }

    // Getter method to return the word
    public String getWord() {
        return word;
    }

    // Getter method to return the minRange
    public int getMinRange() {
        return minRange;
    }

    // Getter method to return the maxRange
    public int getMaxRange() {
        return maxRange;
    }

    // toString method to return a string representation of the instruction
    public String toString() {
        return "Instruction: " + word + "\nLegal range: [" + minRange + ", " + maxRange + "]";
    }

    // Method to check if parameter is in legal range
    public boolean isParameterValid(int userParameter) {
        return minRange <= userParameter && userParameter <= maxRange;
    }
}
