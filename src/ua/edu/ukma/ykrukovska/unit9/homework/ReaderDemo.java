package ua.edu.ukma.ykrukovska.unit9.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class ReaderDemo {

    private static final String FILE_PATH = "C:\\IdeaProjects\\Files\\Text1.txt";

    public static void main(String[] args) {

        Vocabulary vocabulary = new Vocabulary();
        StreamTokenizer text;

        try {
            text = new StreamTokenizer(new BufferedReader(new FileReader(FILE_PATH)));
            int type;

            while ((type = text.nextToken()) != StreamTokenizer.TT_EOF) {
                if (type == StreamTokenizer.TT_WORD) {
                    vocabulary.add(new Lexeme(text.sval));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Amount of words: " + vocabulary.totalCounter());
        System.out.println("Amount of unique words: " + vocabulary.getLexemeCounter());

        Lexeme[] sortedLexemes = vocabulary.getLexemesStatistics();
        for (int i = 0; i < vocabulary.getLexemeCounter(); i++) {
            System.out.println(sortedLexemes[i].getLexemeName() + ": " + sortedLexemes[i].getCounter());
        }

    }
}
