package ru.vvvresearch.homework.dao;

import ru.vvvresearch.homework.domain.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws IOException;
}
