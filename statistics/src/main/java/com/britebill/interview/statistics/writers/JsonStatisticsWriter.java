package com.britebill.interview.statistics.writers;

import com.britebill.interview.statistics.beans.Statistics;
import com.britebill.interview.statistics.constants.StatisticsTags;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;


public class JsonStatisticsWriter implements StatisticsWriter {

    final static Logger log = Logger.getLogger(JsonStatisticsWriter.class);

    public void write(Statistics statistics, File file) {

        JSONObject textStatistics = new JSONObject();

        textStatistics.put(StatisticsTags.TOTAL_NUMBER_OF_WORDS, statistics.getTotalNumberOfWords());
        textStatistics.put(StatisticsTags.TOTAL_NUMBER_OF_UNIQUE_WORDS, statistics.getTotalNumberOfUniqueWords());
        textStatistics.put(StatisticsTags.AVERAGE_CHARACTERS_PER_WORD, statistics.getAverageCharactersPerWord());

        JSONArray mostRepeatedWord = new JSONArray();

        String[] parts = statistics.getMostRepeatedWord().split("_");

        mostRepeatedWord.add(parts[0] + " : " + parts[1]);
        textStatistics.put(StatisticsTags.MOST_REPEATED_WORD, mostRepeatedWord);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(textStatistics.toJSONString());
        } catch (Exception e) {
            log.error("Error while writing json-file: " + e.getMessage());
        }
    }
}
