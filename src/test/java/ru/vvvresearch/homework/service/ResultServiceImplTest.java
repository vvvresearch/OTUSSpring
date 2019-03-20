package ru.vvvresearch.homework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vvvresearch.homework.dao.ResultDao;
import ru.vvvresearch.homework.dao.ResultDaoImpl;
import ru.vvvresearch.homework.domain.Report;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ResultServiceImplTest {
    ResultDao resultDao;
    Report report;

    @BeforeEach
    void init() {
        report = new Report();
        resultDao = new ResultDaoImpl();
        //thenCallRealMethod(report.setTrueAnswerCounter(1));
//        when(resultDao.setFalseAnswerCounter(1)).thenCallRealMethod(report.setFalseAnswerCounter(1));

    }

    @Test
    void getResultReport() {
    }

    @Test
    void incTrueAnswer() {
        ResultService resultService = new ResultServiceImpl(resultDao);
        resultService.incTrueAnswer();
        assertEquals(resultService.getResultReport().getTrueAnswerCounter(), 1);
    }

    @Test
    void incFalseAnswer() {
        ResultService resultService = new ResultServiceImpl(resultDao);
        resultService.incFalseAnswer();
        assertEquals(resultService.getResultReport().getFalseAnswerCounter(), 1);
    }
}