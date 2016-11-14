package com.savko.fourth.reader;

import com.savko.fourth.exception.ReadFileException;
import com.savko.fourth.runner.AppRunner;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TextReader {

    private final static Logger LOGGER = Logger.getLogger(AppRunner.class);

    public static String readFile(String path) throws ReadFileException {
        String text = new String();
        try {
            text = Files.lines(Paths.get(path))
                    .map(String::toString)
                    .collect(Collectors.joining());
        } catch (IOException e) {
            LOGGER.info("Please check your file: " + path, e);
        }
        return text;
    }

}
