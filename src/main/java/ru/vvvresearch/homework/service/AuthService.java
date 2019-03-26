package ru.vvvresearch.homework.service;

import ru.vvvresearch.homework.domain.Person;

public interface AuthService {
    void setAuthData(String sirName, String name);
    Person getStudent();
}
