package com.savko.fourth.parser;

import com.savko.fourth.entity.Composite;
import com.savko.fourth.entity.Component;
import com.savko.fourth.type.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    private static final String PARAGRAPH_DELIMITER = "\\t([^\\t]+)";
    private static final Pattern PATTERN = Pattern.compile(PARAGRAPH_DELIMITER);

    public static Component parse(String inputText) {
        Component text = new Composite(Type.TEXT);

        Matcher matcher = PATTERN.matcher(inputText);

        while (matcher.find()) {
            String paragraph = matcher.group(1).trim();
            Component paragraphComponent = ParagraphParser.parse(paragraph);
            text.add(paragraphComponent);
        }

        return text;
    }

}
