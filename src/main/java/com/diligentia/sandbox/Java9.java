package com.diligentia.sandbox;

import java.util.stream.Stream;

/**
 * Created by rwichrowski on 10.10.17.
 */
public class Java9 {
    public static void main(String[] args) {
        new Java9().startTestJava8();
    }

    private void takeWhileJava9() {
//        Stream.iterate("", s -> s + "s")
//                .takeWhile(s->s.length() < 3)
//                .forEach(this::log);
    }

    private void startTestJava8() {
        Stream.iterate("a", s -> s + "s")
                .filter(s->s.length() < 30)
                .forEach(this::log);
    }

    private void log(String string) {
        System.err.println(string);
    }
}
