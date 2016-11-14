package com.savko.fourth.task;

import com.savko.fourth.entity.Component;
import com.savko.fourth.entity.Composite;
import com.savko.fourth.type.Type;

import java.util.Iterator;
import java.util.List;

public class DeleteLexemes {

    public static void process(Composite composite, int length, char letter) {
        for(Component component : composite.getComponents()) {
            if(component.getType() == Type.LEXEME) {
                Composite sentence = (Composite) component;
                List<Component> lexemes = sentence.getComponents();
                Iterator<Component> iterator = lexemes.iterator();
                while (iterator.hasNext()) {
                    Component current = iterator.next();
                    if (current.toString().length() == length && current.toString().charAt(0) == letter) {
                        iterator.remove();
                    }
                }
            } else {
                process((Composite) component, length, letter);
            }
        }
    }

}
