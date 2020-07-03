package ua.edu.ukma.ykrukovska.unit12.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordCounter {

    private final static String FOLDER = "C:\\IdeaProjects\\Files\\";
    private static List<String> files = new ArrayList<String>();
    private Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        try {
            wordCounter.calculateWords();
        } catch (IOException e) {
            System.out.println("Failed to open file  for reading. Please check parameters");
        }
    }

    public void calculateWords() throws IOException {
        initFiles();

        StreamTokenizer text;
        for (String fileName : files) {

            text = new StreamTokenizer(new BufferedReader(new FileReader(FOLDER + fileName)));
            int type;

            while ((type = text.nextToken()) != StreamTokenizer.TT_EOF) {
                if (type == StreamTokenizer.TT_WORD) {
                    dictionary.addWord(fileName, text.sval.toLowerCase());
                }
            }
        }
        printStatistic();
        saveToDisc();
    }

    private void saveToDisc() {
        try (PrintWriter writer = new PrintWriter(FOLDER + "Dictionary.txt")) {
            for (WordStat wordStat : dictionary.getVocabulary().values()) {
                writer.print(wordStat.getWord() + " " + wordStat.getAllOccurrencesCount() + System.lineSeparator());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File's not found, results will be printed in console");
            for (WordStat wordStat : dictionary.getVocabulary().values()) {
                System.out.print(wordStat.getWord() + " " + wordStat.getAllOccurrencesCount() + System.lineSeparator());
            }
        }
    }

    private void printStatistic() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FOLDER + "DictionaryFull.txt");
        } catch (FileNotFoundException e) {
            File resultFile = new File(FOLDER + "DictionaryFull.txt");
            try {
                writer = new PrintWriter(resultFile);
            } catch (FileNotFoundException e1) {
                System.out.println("File's not found");
            }
        }

        writer.print(dictionary.toString());
    }

    private void initFiles() {
        files.add("Text1.txt");
    }
}
