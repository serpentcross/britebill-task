package com.britebill.interview.statistics.writers;

import com.britebill.interview.statistics.beans.Statistics;
import com.britebill.interview.statistics.constants.StatisticsTags;

import org.apache.log4j.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;


public class XmlStatisticsWriter implements StatisticsWriter {

    private final static Logger log = Logger.getLogger(XmlStatisticsWriter.class);

    public void write(Statistics statistics, File file) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document xmlDocument = docBuilder.newDocument();
            Element root = xmlDocument.createElement(StatisticsTags.TEXT_STATISTICS);
            xmlDocument.appendChild(root);

            Element totalNumberOfWords = xmlDocument.createElement(StatisticsTags.TOTAL_NUMBER_OF_WORDS);
            totalNumberOfWords.appendChild(xmlDocument.createTextNode(Long.toString(statistics.getTotalNumberOfWords())));
            root.appendChild(totalNumberOfWords);

            Element totalNumberOfUniqueWords = xmlDocument.createElement(StatisticsTags.TOTAL_NUMBER_OF_UNIQUE_WORDS);
            totalNumberOfUniqueWords.appendChild(xmlDocument.createTextNode(Long.toString(statistics.getTotalNumberOfUniqueWords())));
            root.appendChild(totalNumberOfUniqueWords);

            Element averageCharactersPerWord = xmlDocument.createElement(StatisticsTags.AVERAGE_CHARACTERS_PER_WORD);
            averageCharactersPerWord.appendChild(xmlDocument.createTextNode(Long.toString(statistics.getAverageCharactersPerWord())));
            root.appendChild(averageCharactersPerWord);

            Element mostRepeatedWord = xmlDocument.createElement(StatisticsTags.MOST_REPEATED_WORD);
            root.appendChild(mostRepeatedWord);

            String[] parts = statistics.getMostRepeatedWord().split("_");

            Element word = xmlDocument.createElement(StatisticsTags.WORD);
            word.appendChild(xmlDocument.createTextNode(parts[0]));
            mostRepeatedWord.appendChild(word);

            Element wasRepeated = xmlDocument.createElement(StatisticsTags.WAS_REPEATED);
            wasRepeated.appendChild((xmlDocument.createTextNode(parts[1])));
            mostRepeatedWord.appendChild(wasRepeated);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(xmlDocument);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);

        } catch (Exception ex) {
            log.error("Error while writing xml-file: " + ex.getMessage());
        }
    }
}
