package ru.vvvresearch.homework.dao;

import ru.vvvresearch.homework.domain.Person;

public interface PersonDao {
    Person getPerson() throws NullPointerException;
    void setPersonFromString(String sirName, String name);
}
