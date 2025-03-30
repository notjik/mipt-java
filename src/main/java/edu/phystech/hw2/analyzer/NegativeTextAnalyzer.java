package edu.phystech.hw2.analyzer;


import java.util.List;

public class NegativeTextAnalyzer extends KeywordAnalyzer {
    private static final List<String> NEGATIVE_KEYWORDS = List.of(":(", "=(", ":|");

    public NegativeTextAnalyzer() {
        super(NEGATIVE_KEYWORDS, Label.NEGATIVE);
    }
}
