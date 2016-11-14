package com.savko.fourth.parser;

import com.savko.fourth.entity.Component;
import com.savko.fourth.entity.Composite;
import com.savko.fourth.entity.Leaf;
import com.savko.fourth.type.Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser {

    private static final String LEXEME_REGEX = "([a-zA-Z'-]+)([,:-?!/.])";
    private static final String WORD_REGEX = "[a-zA-Z'-]+";
    private static final Pattern LEXEME_PATTERN = Pattern.compile(LEXEME_REGEX);
    private static final Pattern WORD_PATTERN = Pattern.compile(WORD_REGEX);

    public static Component parse(String inputLexeme) {

        Component lexeme = new Composite(Type.LEXEME);

        Matcher lexemeMatcher = LEXEME_PATTERN.matcher(inputLexeme);
        if(lexemeMatcher.find()) {
            Component word = new Leaf(Type.WORD, lexemeMatcher.group(1));
            Component mark = new Leaf(Type.MARK, lexemeMatcher.group(2));
            lexeme.add(word);
            lexeme.add(mark);
        } else {
            Matcher wordMatcher = WORD_PATTERN.matcher(inputLexeme);
            if(wordMatcher.matches()) {
                Component word = new Leaf(Type.WORD, inputLexeme);
                lexeme.add(word);
            } else {
                Component expression = new Leaf(Type.EXPRESSION, inputLexeme);
                lexeme.add(expression);
            }
        }
        return lexeme;
    }

}
