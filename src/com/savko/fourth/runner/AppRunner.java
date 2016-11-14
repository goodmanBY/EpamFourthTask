package com.savko.fourth.runner;

import com.savko.fourth.entity.Component;
import com.savko.fourth.entity.Composite;
import com.savko.fourth.exception.ReadFileException;
import com.savko.fourth.parser.TextParser;
import com.savko.fourth.reader.TextReader;
import com.savko.fourth.tasks.DeleteLexemes;
import com.savko.fourth.tasks.ModifyLexeme;
import com.savko.fourth.tasks.SwitchLexemes;
import org.apache.log4j.Logger;

public class AppRunner {

    private static final String PATH = "data/OriginalText";
    private final static Logger LOGGER = Logger.getLogger(AppRunner.class);

    public static void main(String args[]) {

        LOGGER.info("Program started");

        try {

            Component component = (TextParser.parse(TextReader.readFile(PATH)));
            LOGGER.info("The initial text.");
            LOGGER.info(component);

            component = (TextParser.parse(TextReader.readFile(PATH)));
            SwitchLexemes.process((Composite) component);
            LOGGER.info("Task 3. Text where lexemes has been switched.");
            LOGGER.info(component);

            component = (TextParser.parse(TextReader.readFile(PATH)));
            DeleteLexemes.process((Composite) component, 4, 'l');
            LOGGER.info("Task 6. Text where lexemes has been deleted by length and first letter.");
            LOGGER.info(component);

            component = (TextParser.parse(TextReader.readFile(PATH)));
            ModifyLexeme.process((Composite) component);
            LOGGER.info("Task 8. Text where modified next lexemes by first letter.");
            LOGGER.info(component);

        } catch (ReadFileException e) {
            LOGGER.info("Can't read data from file: " + PATH, e);
        }

    }

}
