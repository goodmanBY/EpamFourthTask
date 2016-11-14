package com.savko.fourth.parser;

import com.savko.fourth.entity.Composite;
import com.savko.fourth.entity.Component;
import com.savko.fourth.type.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final String LEXEME_REGEX = "(\\S+)";
    private static final Pattern PATTERN = Pattern.compile(LEXEME_REGEX);

    public static Component parse(String inputSentence) {

        Component sentence = new Composite(Type.SENTENCE);
        Matcher matcher = PATTERN.matcher(inputSentence);

        while (matcher.find()) {
            String lexeme = matcher.group(1).trim();
            Component lexemeComponent = LexemeParser.parse(lexeme);
            sentence.add(lexemeComponent);
        }

        return sentence;
    }

}
