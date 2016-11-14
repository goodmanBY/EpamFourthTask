package com.savko.fourth.entity;

import com.savko.fourth.type.Type;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private Type type;
    private List<Component> components;

    public Composite(Type type) {
        this.type = type;
        this.components = new ArrayList<>();
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void add(Component component){
        this.components.add(component);
    }

    @Override
    public void remove(Component component) {
        this.components.remove(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        components.forEach(stringBuilder::append);
        return  stringBuilder.append(" ").toString();
    }
}
