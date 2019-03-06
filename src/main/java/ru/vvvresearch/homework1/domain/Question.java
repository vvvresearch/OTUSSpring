package ru.vvvresearch.homework1.domain;

import java.util.List;

public abstract class Question {
    private String question;
    private List<Answer> answers;

    public abstract String getQuestion();

    public abstract List<Answer> getAnswers();
}
