package ru.vvvresearch.homework.dao;

import ru.vvvresearch.homework.domain.Report;

public interface ResultDao {
    Report getReport();
    void setTrueAnswerCounter(int counter);
    void setFalseAnswerCounter(int counter);
}
