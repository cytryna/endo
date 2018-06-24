package com.diligentia;

import java.math.BigDecimal;

public class Member {

    private final String name;
    private BigDecimal score;

    public Member(String name, BigDecimal score) {
        //TODO pobrać właściwe nazwisko dla dowolnego usera

        if ("Ty".equals(name)) {
            name = "Radosław Wichrowski";
        }
        this.name = name;
        this.score = score;
//        System.err.println(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
