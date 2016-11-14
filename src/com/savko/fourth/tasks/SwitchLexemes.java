package com.savko.fourth.tasks;

import com.savko.fourth.entity.Component;
import com.savko.fourth.entity.Composite;
import com.savko.fourth.type.Type;

import java.util.List;

public class SwitchLexemes {

    public static void process(Composite composite) {

        for (Component component : composite.getComponents()) {
            if (component.getType() == Type.SENTENCE) {
                Composite sentence = (Composite) component;
                List<Component> lexemes = sentence.getComponents();
                Component firstLexeme = lexemes.get(0);
                Component lastLexeme = lexemes.get(lexemes.size() - 1);
                lexemes.set(lexemes.size() - 1, firstLexeme);
                lexemes.set(0, lastLexeme);
            } else {
                if (component.getType() == Type.PARAGRAPH) {
                    process((Composite) component);
                }
            }
        }
    }

}
