package ua.edu.ukma.ykrukovska.unit9.homework;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VocabularyTest {



    @Test
    public void addFirstLexeme(){

        Vocabulary vocabulary = new Vocabulary();
        vocabulary.add(new Lexeme("First"));
        Assert.assertEquals(1, vocabulary.getLexemeCounter());


    }
    @Test
    public void addLexemeTwice(){

        Vocabulary vocabulary = new Vocabulary();
        vocabulary.add(new Lexeme("First"));
        vocabulary.add(new Lexeme("First"));
        vocabulary.add(new Lexeme("Second"));
        Assert.assertEquals(2, vocabulary.getLexemeCounter());
        Assert.assertEquals(2, vocabulary.getLexeme("First").getCounter());
        Assert.assertEquals(1, vocabulary.getLexeme("Second").getCounter());


    }

    @Test
    public void sortByName(){

        Vocabulary vocabulary = new Vocabulary();
        vocabulary.add(new Lexeme("Second"));
        vocabulary.add(new Lexeme("First"));
        vocabulary.add(new Lexeme("Third"));
        vocabulary.add(new Lexeme("First"));
        Assert.assertEquals(3, vocabulary.getLexemeCounter());
        Assert.assertEquals(2, vocabulary.getLexeme("First").getCounter());
        Assert.assertEquals(1, vocabulary.getLexeme("Second").getCounter());
        Assert.assertEquals(1, vocabulary.getLexeme("Third").getCounter());

        Lexeme[] lexemes = vocabulary.getLexemesStatistics();

        Assert.assertEquals("First", lexemes[0].getLexemeName());
        Assert.assertEquals("Second", lexemes[1].getLexemeName());
        Assert.assertEquals("Third", lexemes[2].getLexemeName());

        Assert.assertEquals(2, lexemes[0].getCounter());
        Assert.assertEquals(1, lexemes[1].getCounter());
        Assert.assertEquals(1, lexemes[2].getCounter());
        Assert.assertEquals(4, vocabulary.totalCounter());
    }

}