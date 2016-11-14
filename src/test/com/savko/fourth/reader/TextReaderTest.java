package test.com.savko.fourth.reader;

import com.savko.fourth.exception.ReadFileException;
import com.savko.fourth.reader.TextReader;
import org.junit.Assert;
import org.junit.Test;

public class TextReaderTest {

    @Test
    public void testSquareOfCircle() throws ReadFileException {
        String path = "data/TestText";
        String test = "Hello it's test!";
        String resultText= TextReader.readFile(path);
        Assert.assertEquals(test, resultText);
    }

}
