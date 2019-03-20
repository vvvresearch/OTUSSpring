package ru.vvvresearch.homework.domain;

public class Person {
    private String sirname;
    private String name;

    public Person(String sirname, String name) {
        this.sirname = sirname;
        this.name = name;
    }

    public String getSirname() {
        return sirname;
    }

    public String getName() {
        return name;
    }
}
