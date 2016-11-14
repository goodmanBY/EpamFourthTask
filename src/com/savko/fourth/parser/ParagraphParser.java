package com.savko.fourth.parser;

import com.savko.fourth.entity.Component;
import com.savko.fourth.entity.Composite;
import com.savko.fourth.type.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser {

    private static final String SENTENCE_DELIMITER = "([^.?!]+[.?!])";
    private static final Pattern PATTERN = Pattern.compile(SENTENCE_DELIMITER);


    public static Component parse(String inputParagraph) {
        Component paragraph = new Composite(Type.PARAGRAPH);

        Matcher matcher = PATTERN.matcher(inputParagraph);

        while (matcher.find()) {
            String sentence = matcher.group(1).trim();
            Component sentenceComponent = SentenceParser.parse(sentence);
            paragraph.add(sentenceComponent);
        }

        return paragraph;

    }

}
