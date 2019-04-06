package ua.edu.ukma.ykrukovska.unit12.homework;

import java.util.Map;
import java.util.TreeMap;

public class Dictionary {

    private Map<String, WordStat> vocabulary = new TreeMap<>();

    public void addWord(String file, String word) {

        WordStat entity = vocabulary.get(word);

        if (entity == null) {
            entity = new WordStat(word);
            entity.addWord(file);
            vocabulary.put(word, entity);
        } else {
            entity.addWord(file);
        }
    }


    @Override
    public String toString() {
        long total = 0;
        String details = "";

        for (WordStat wordStat : vocabulary.values()) {
            long allOccurrences = wordStat.getAllOccurrencesCount();
            total += allOccurrences;

            details += wordStat.toString() + System.lineSeparator();
        }

        long totalUnique = vocabulary.size();


        return "Total amount of words: " + total + System.lineSeparator() + "Total unique words: " + totalUnique
                + System.lineSeparator() + details;
    }

    public Map<String, WordStat> getVocabulary() {
        return vocabulary;
    }


}
