package org.example;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Sparrow {
    private String name;

    @PostConstruct // выполняется сразу после создания бина
    public void init() {
        this.name = "Spar";
    }

    @PreDestroy // выполняется непосредственно перед закрытием и очисткой контекста
                // попытка очистить контекст Spring может оказаться неудачной
    public void destroy() {
        System.out.println("Sparrow destroyed");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
