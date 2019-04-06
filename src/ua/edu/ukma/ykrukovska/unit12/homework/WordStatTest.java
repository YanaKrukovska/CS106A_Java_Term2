package ua.edu.ukma.ykrukovska.unit12.homework;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordStatTest {


    @Test
    public void addWord(){
        WordStat wordStat = new WordStat("baby");
        wordStat.addWord("Text1.txt");
        wordStat.addWord("Text2.txt");
        wordStat.addWord("Text2.txt");

        Assert.assertEquals(new Long(3), wordStat.getAllOccurrencesCount());
        System.out.println(wordStat.toString());


    }

}