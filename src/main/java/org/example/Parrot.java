package org.example;

import org.springframework.stereotype.Component;

@Component("parrot")
public class Parrot {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
