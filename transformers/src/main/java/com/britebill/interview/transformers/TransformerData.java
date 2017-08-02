package com.britebill.interview.transformers;

import com.britebill.interview.statistics.util.WordFilter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TransformerData {

    final static Logger log = Logger.getLogger(TransformerData.class);

    public List<String> transformData(List<String> src) {
        // TODO: Add here your code

        WordFilter wordFilter = new WordFilter();

        if (src == null || src.size() == 0) {
           src = new ArrayList<>();
           log.warn("Seems that input data was empty.");
        }

        List<String> transformedData = wordFilter.getPureWordsFromData(src);

        transformedData.replaceAll(String::toUpperCase);

        transformedData.sort(Comparator.naturalOrder());                    // just in case - sorting in alphabetical order

        transformedData.sort(Comparator.comparing(s -> s.length()));

        return transformedData.stream().distinct().collect(Collectors.toList());
    }
}
