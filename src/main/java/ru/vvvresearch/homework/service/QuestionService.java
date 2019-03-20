package ru.vvvresearch.homework.service;

import java.util.List;

public interface QuestionService{
    boolean checkAnswer(int numberOfAnswer);
    String getQuestion();
    List<String> getAnswers();
    boolean hasNextQuestion();
}
