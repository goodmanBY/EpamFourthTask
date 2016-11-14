package com.savko.fourth.tasks;

import com.savko.fourth.entity.Component;
import com.savko.fourth.entity.Composite;
import com.savko.fourth.entity.Leaf;
import com.savko.fourth.type.Type;

public class ModifyLexeme {

    public static void process(Composite composite) {
        for (Component component : composite.getComponents()) {
            if (component.getType() == Type.WORD) {
                Leaf word = (Leaf) component;
                char firstLetter = word.getValue().charAt(0);
                StringBuilder b = new StringBuilder(Character.toString(firstLetter));
                for (char c: word.getValue().toCharArray()){
                    if (c != firstLetter){
                        b.append(c);
                    }
                }
                word.setValue(b.toString());
            } else {
                if(component.getType() != Type.EXPRESSION && component.getType() != Type.MARK) {
                    process((Composite) component);
                }
            }
        }

    }
}