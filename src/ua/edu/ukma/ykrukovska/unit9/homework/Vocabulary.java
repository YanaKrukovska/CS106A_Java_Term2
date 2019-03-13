package ua.edu.ukma.ykrukovska.unit9.homework;

public class Vocabulary {

    private int lexemeCounter;
    private int totalCounter;
    private static final int MAX_SIZE = 1000;

    Lexeme[] lexemes = new Lexeme[MAX_SIZE];


    public void add(Lexeme lexeme) {

        boolean isLexemePresent = false;

        for (int i = 0; i < lexemeCounter; i++) {
            if (lexemes[i].getLexemeName().equals(lexeme.getLexemeName())) {
                lexemes[i].increaseCounter();
                isLexemePresent = true;
                break;
            }
        }
        if (!isLexemePresent) {
            lexemes[lexemeCounter++] = lexeme;

        }
        totalCounter++;

    }

    public int getLexemeCounter() {
        return lexemeCounter;
    }

    public Lexeme getLexeme(String lexeme) {

        for (int i = 0; i < lexemeCounter; i++) {
            if (lexemes[i].getLexemeName().equals(lexeme)) {
                return lexemes[i];
            }
        }
        return null;
    }

    public Lexeme[] sortByName(Lexeme[] lexemes) {


        boolean isSwapped = false;
        do {
            isSwapped = false;
            for (int i = 0; i < lexemeCounter - 1; i++) {
                if (lexemes[i].getLexemeName().compareTo(lexemes[i + 1].getLexemeName()) > 0) {
                    Lexeme temp = lexemes[i + 1];
                    lexemes[i + 1] = lexemes[i];
                    lexemes[i] = temp;
                    isSwapped = true;
                }
            }
        } while ((isSwapped));


        return lexemes;
    }

    public Lexeme[] getLexemesStatistics() {

        return sortByName(lexemes);
    }

    public int totalCounter() {

        return totalCounter;
    }
}
