package com.britebill.interview.statistics.util;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class WordFilter {

    // I assume that we need pure words, without unknown symbols. Is it correct ?

    final static Logger log = Logger.getLogger(WordFilter.class);

    public List<String> getPureWordsFromData(List<String> data) {

        if (data == null || data.size() == 0) {
            data = new ArrayList<>();
            log.warn("Seems that input data was empty.");
        }

        List<String> countedWords = new ArrayList<>();
        boolean isSingleWord = false;
        int endOfSentence;

        for (String singleWord : data) {
            endOfSentence = singleWord.length() - 1;
            for(int i = 0; i < singleWord.length(); i++) {
                if (Character.isLetter(singleWord.charAt(i)) && i != endOfSentence) {
                    isSingleWord = true;
                } else if (!Character.isLetter(singleWord.charAt(i)) && isSingleWord) {
                    isSingleWord = false;
                } else if (Character.isLetter(singleWord.charAt(i)) && i == endOfSentence) {
                    countedWords.add(singleWord);
                }
            }
        }

        return countedWords;
    }
}
