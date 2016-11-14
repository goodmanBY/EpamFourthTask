package com.savko.fourth.entity;

import com.savko.fourth.type.Type;

public interface Component {

    Type getType();

    void add(Component component);

    void remove(Component component);

}
