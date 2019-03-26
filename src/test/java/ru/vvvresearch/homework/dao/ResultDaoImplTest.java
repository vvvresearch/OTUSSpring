package ru.vvvresearch.homework.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vvvresearch.homework.domain.Report;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResultDaoImplTest {
    @Autowired
    ResultDao resultDao;

    @BeforeAll
    static void beforeTest() {

    }

    @Test
    void getReport() {
        assertNotNull(resultDao.getReport());
    }

    @Test
    void setTrueAnswerCounter() {
        resultDao.setTrueAnswerCounter(10);
        assertEquals(10, resultDao.getReport().getTrueAnswerCounter());
    }

    @Test
    void setFalseAnswerCounter() {
        resultDao.setFalseAnswerCounter(10);
        assertEquals(10, resultDao.getReport().getFalseAnswerCounter());
    }
}