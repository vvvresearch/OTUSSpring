package ru.vvvresearch.homework1.dao;

import ru.vvvresearch.homework1.domain.Question;
import ru.vvvresearch.homework1.domain.QuestionFromCSV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface QuestionDao {
    List<Question> getQuestions() throws IOException;
}
