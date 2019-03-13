package ua.edu.ukma.ykrukovska.unit9.homework;


public class Lexeme {

    private String lexeme;
    private int counter;


    public Lexeme(String lexeme) {
        this.lexeme = lexeme.toLowerCase();
        counter = 1;
    }

    public void increaseCounter() {
        counter++;
    }

    public String getLexemeName() {
        return lexeme;
    }

    public int getCounter() {
        return counter;
    }


}
