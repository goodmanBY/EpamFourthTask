package com.savko.fourth.entity;

import com.savko.fourth.converter.PolishFormConverter;
import com.savko.fourth.interpreter.MathExpression;
import com.savko.fourth.type.Type;

public class Leaf implements Component {

    private String value;
    private Type type;

    public Leaf(Type type, String value) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {

        if(type == Type.EXPRESSION) {
            PolishFormConverter converter = new PolishFormConverter();
            MathExpression client = new MathExpression(converter.convert(value));
            return client.calculate().toString();
        }
        return value;

    }
}
