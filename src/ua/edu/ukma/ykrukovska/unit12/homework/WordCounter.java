package ua.edu.ukma.ykrukovska.unit12.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

    private static Map<String, Integer> dictionary = new HashMap<>();
    private final static String FILE1 = "C:\\IdeaProjects\\Files\\Text1.txt";
    private static List<String> files = new ArrayList<>();

    public static void main(String[] args) {

files.add(FILE1);
        StreamTokenizer text;

        try {
            text = new StreamTokenizer(new BufferedReader(new FileReader(FILE1)));
            int type;

            while ((type = text.nextToken()) != StreamTokenizer.TT_EOF) {
                if (type == StreamTokenizer.TT_WORD) {
                    countWords(text.sval);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void countWords(String word) {
        Integer count = dictionary.get(word);
        if (count == null)  {
            dictionary.put(word, 1);
        } else {
            dictionary.put(word, count + 1);
        }

    }


}
