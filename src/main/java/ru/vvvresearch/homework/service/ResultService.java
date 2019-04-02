package ru.vvvresearch.homework.service;

import ru.vvvresearch.homework.domain.Report;

public interface ResultService {
    Report getResultReport ();
    void incTrueAnswer();
    void incFalseAnswer();
}
