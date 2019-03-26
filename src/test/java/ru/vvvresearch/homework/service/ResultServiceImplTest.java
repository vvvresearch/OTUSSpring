package ru.vvvresearch.homework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vvvresearch.homework.dao.ResultDao;
import ru.vvvresearch.homework.dao.ResultDaoImpl;
import ru.vvvresearch.homework.domain.Report;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@SpringBootTest
class ResultServiceImplTest {
    @Autowired
    ResultDao resultDao;

    Report report;

    @BeforeEach
    void init() {
        report = new Report();
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