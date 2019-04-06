package ua.edu.ukma.ykrukovska.unit12.homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void addWord() {

        Dictionary dictionary = new Dictionary();
        dictionary.addWord("text1", "baby");
        dictionary.addWord("text1", "baby");
        dictionary.addWord("text2", "baby");
        dictionary.addWord("text1", "girls");
        dictionary.addWord("text2", "baby");
        dictionary.addWord("text1", "girls");
        dictionary.addWord("text4", "girls");
        dictionary.addWord("text1", "girls");
        dictionary.addWord("text1", "baby");
        System.out.println(dictionary.toString());
    }
}