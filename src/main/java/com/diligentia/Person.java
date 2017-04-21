package com.diligentia;

public class Person {

	private final String name;
	private int score;

	public Person(String name, int score) {
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
