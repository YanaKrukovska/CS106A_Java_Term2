package ua.edu.ukma.ykrukovska.unit12.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordStat implements Comparable {

    private String word;
    private Map<String, Long> statistics = new HashMap<>();


    public WordStat(String word) {
        this.word = word;
    }

    public void addWord(String fileName) {
        Long count = statistics.get(fileName);
        if (count == null) {
            statistics.put(fileName, 1L);
        } else {
            statistics.put(fileName, count + 1);
        }

    }

    public Long getAllOccurrencesCount() {
        long count = 0;
        for (long fileCount : statistics.values()) {
            count += fileCount;
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordStat wordStat = (WordStat) o;
        return Objects.equals(word, wordStat.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        String fileDetails = "";

        for (Map.Entry<String, Long> entry : statistics.entrySet()) {
            fileDetails += entry.getKey() + ": " + entry.getValue() + System.lineSeparator();
        }

        return word + "[" + getAllOccurrencesCount() + "]" +  System.lineSeparator() + fileDetails;
    }

    @Override
    public int compareTo(Object o) {
        WordStat otherWord = (WordStat) o;
        return word.compareTo(otherWord.word);
    }

    public String getWord() {
        return word;
    }
}
