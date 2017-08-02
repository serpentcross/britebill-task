package com.britebill.interview.statistics.calculator;

import com.britebill.interview.statistics.util.WordFilter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class StatisticsCalculator {

    private WordFilter wordFilter = new WordFilter();

    final static Logger log = Logger.getLogger(WordFilter.class);

    public Long getTotalNumberOfWords(List<String> data) {
        // TODO Add the implementation to get the total number of words here
        return (long) wordFilter.getPureWordsFromData(data).size();
    }

    public Long getTotalNumberOfUniqueWords(List<String> data) {
        // TODO Add the implementation to get the unique words list here

        Set<String> uniqueWords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        uniqueWords.addAll(data);
        data = new ArrayList<>(uniqueWords);
        return (long) wordFilter.getPureWordsFromData(data).size();
    }

    public Long getAverageCharactersPerWord(List<String> data) {
        // TODO Add the implementation to get the average characters per words here

        int counter = 0;
        double sum = 0;
        double averageNumber = 0;

        if (data == null || data.size() == 0) {
            data = new ArrayList<>();
            log.warn("Seems that input data was empty.");
        }

        for (String singleWord : data) {
            double charNum = singleWord.length();
            sum = charNum + sum;
            counter++;
        }

        if ( counter > 0 ) {
            averageNumber = sum / counter;
        }

        return Math.round(averageNumber);
    }

    public String getMostRepeatedWord(List<String> data) {
        // TODO Add the implementation to get the most repeated word here

        if (data == null || data.size() == 0) {
            data = new ArrayList<>();
            log.warn("Seems that input data was empty.");
        }

        Map<String, Integer> storage = new HashMap<>();

        for (String singleWord : data) {
            Integer frequency = storage.get(singleWord);
            if(frequency == null) {
                storage.put(singleWord, 1);
            } else {
                storage.put(singleWord, frequency + 1);
            }
        }

        return findMostFrequent(storage.entrySet());
    }

    private String findMostFrequent(Set<Map.Entry<String, Integer>> data) {
        TreeSet<Map.Entry<String, Integer>> sorted = new TreeSet<Map.Entry<String, Integer>>((e1, e2) -> e1.getValue() < e2.getValue() ? 1 : -1);
        sorted.addAll(data);
        return sorted.iterator().next().getKey()  + "_" + sorted.iterator().next().getValue();
    }

}
