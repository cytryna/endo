package com.diligentia;

import java.math.BigDecimal;

public class Person {

    private final String name;
    private BigDecimal score;

    public Person(String name, BigDecimal score) {
        if ("Ty".equals(name)) {
            name = "Radosław Wichrowski";
        }
        this.name = name;
        this.score = score;
        System.err.println(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
