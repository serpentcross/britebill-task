package com.britebill.interview.statistics;

import com.britebill.interview.statistics.beans.Statistics;
import com.britebill.interview.statistics.calculator.StatisticsCalculator;
import com.britebill.interview.statistics.writers.JsonStatisticsWriter;
import com.britebill.interview.statistics.writers.XmlStatisticsWriter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatisticsTest {

    private StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
    private Statistics testStatistic = new Statistics();

    private List<String> dummyData = new ArrayList<>(
            Arrays.asList(
                    "unplait",
                    "globulin",
                    "globulins",
                    "scouring",
                    "corkwing",
                    "s",
                    "scours",
                    "scourway",
                    "unplait",
                    "globulinuria",
                    "globulysis",
                    "red-flag",
                    "co",
                    "cork-tipped",
                    "unplait",
                    "corkwing",
                    "corkwood",
                    "red-flagger",
                    "unplait",
                    "red-flaggery",
                    "powwowed",
                    "powwows",
                    "red-flanked",
                    "red-flecked",
                    "red-flesheda",
                    "lthein",
                    "altheine",
                    "Altheta",
                    "s",
                    "scouriness",
                    "corkwing",
                    "scourweed",
                    "unplained",
                    "unplainly",
                    "unplainness",
                    "unplait",
                    "scourwort",
                    "Scouse",
                    "Althing",
                    "althionic",
                    "corkwing",
                    "altho",
                    "althorn",
                    "unplait"
            )
    );

    @Test
    public void testXmlGeneration() throws IOException {
        // TODO: Add your Test implementation here
        XmlStatisticsWriter xmlStatisticsWriter = new XmlStatisticsWriter();

        testStatistic.setTotalNumberOfWords(206);
        testStatistic.setTotalNumberOfUniqueWords(103);
        testStatistic.setAverageCharactersPerWord(5);
        testStatistic.setMostRepeatedWord("no_44");

        xmlStatisticsWriter.write(testStatistic, new File("test-output.xml"));
    }

    @Test
    public void testJsonGeneration() throws IOException {
        // TODO: Add your Test implementation here

        JsonStatisticsWriter jsonStatisticsWriter = new JsonStatisticsWriter();

        testStatistic.setTotalNumberOfWords(206);
        testStatistic.setTotalNumberOfUniqueWords(103);
        testStatistic.setAverageCharactersPerWord(5);
        testStatistic.setMostRepeatedWord("no_44");

        jsonStatisticsWriter.write(testStatistic, new File("test-output.json"));
    }

    @Test
    public void testTotalNumberOfWords() {
        // TODO: Add your Test implementation here
        statisticsCalculator.getTotalNumberOfWords(dummyData);
    }

    @Test
    public void testTotalNumberOfUniqueWords() {
        // TODO: Add your Test implementation here
        statisticsCalculator.getTotalNumberOfUniqueWords(dummyData);
    }

    @Test
    public void testAverageCharactersPerWord() {
        // TODO: Add your Test implementation here
        statisticsCalculator.getAverageCharactersPerWord(dummyData);
    }

    @Test
    public void testMostRepeatedWord() {
        // TODO: Add your Test implementation here
        statisticsCalculator.getMostRepeatedWord(dummyData);
    }
}



