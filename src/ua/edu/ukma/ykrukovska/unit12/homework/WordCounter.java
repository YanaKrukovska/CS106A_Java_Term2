package ua.edu.ukma.ykrukovska.unit12.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordCounter {

    private final static String FOLDER = "C:\\IdeaProjects\\Files\\";
    private final static String FILE1 = "Text1.txt";
    private final static String FILE2 = "Text2.txt";
    private static List<String> files = new ArrayList<String>();
    private Dictionary dictionary = new Dictionary();


    public static void main(String[] args) throws IOException {
        WordCounter wordCounter = new WordCounter();
        wordCounter.calculateWords();
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

    private void saveToDisc() throws IOException {
        PrintWriter writer = new PrintWriter(FOLDER + "Dictionary.txt", "UTF-8");

        for (WordStat wordStat : dictionary.getVocabulary().values()) {

            writer.print(wordStat.getWord() + " " + wordStat.getAllOccurrencesCount() + System.lineSeparator());
        }
        writer.close();
    }

    private void printStatistic() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(FOLDER + "DictionaryFull.txt", "UTF-8");

        writer.print(dictionary.toString());
    }


    private void initFiles() {
        files.add("Text1.txt");
        files.add("Text2.txt");
        files.add("Text3.txt");
        files.add("Text4.txt");
        files.add("Text5.txt");
        files.add("Text6.txt");
        files.add("Text7.txt");
        files.add("Text8.txt");
        files.add("Text9.txt");
        files.add("Text10.txt");


    }


}
