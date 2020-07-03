package ua.edu.ukma.ykrukovska.unit12.homework;

import java.util.Comparator;

public class FrequencyComparator implements Comparator<WordStat> {
    @Override
    public int compare(WordStat o1, WordStat o2) {
        long o1Count = o1.getAllOccurrencesCount();
        long o2Count = o2.getAllOccurrencesCount();

        if (o1Count == o2Count) {
            return 0;
        } else if (o1Count < o2Count) {
            return -1;
        } else {
            return 1;
        }
    }
}
