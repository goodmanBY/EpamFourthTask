package com.savko.fourth.interpreter;

public class TerminalExpressionMultiply extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        if (context != null) {
            context.pushValue(context.popValue() * context.popValue());
        }
    }
}
