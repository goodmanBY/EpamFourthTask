package test.com.savko.fourth.interpreter;

import com.savko.fourth.converter.PolishFormConverter;
import com.savko.fourth.interpreter.MathExpression;
import org.junit.Assert;
import org.junit.Test;

public class MathExpressionTest {

    @Test
    public void calculateCorrectExpressionTest() {
        String expression = "13+(3++)";
        PolishFormConverter converter = new PolishFormConverter();
        MathExpression mathExpression = new MathExpression(converter.convert(expression));
        String actual = mathExpression.calculate().toString();
        String expected = "17";
        Assert.assertEquals(expected, actual);
    }
}