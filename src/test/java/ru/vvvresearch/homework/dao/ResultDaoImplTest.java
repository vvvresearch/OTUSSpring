package ru.vvvresearch.homework.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import ru.vvvresearch.homework.domain.Report;

import static org.junit.jupiter.api.Assertions.*;

class ResultDaoImplTest {

    ResultDao resultDao = new ResultDaoImpl();;
    @BeforeAll
    static void beforeTest(){

    }
    @Test
    void getReport() {
        assertNotNull(resultDao.getReport());
    }

    @Test
    void setTrueAnswerCounter() {
        resultDao.setTrueAnswerCounter(10);
        assertEquals(10,resultDao.getReport().getTrueAnswerCounter());
    }

    @Test
    void setFalseAnswerCounter() {
        resultDao.setFalseAnswerCounter(10);
        assertEquals(10,resultDao.getReport().getFalseAnswerCounter());
    }
}