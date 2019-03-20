package ru.vvvresearch.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vvvresearch.homework.dao.ResultDao;
import ru.vvvresearch.homework.domain.Report;

@Service
public class ResultServiceImpl implements ResultService {
    private ResultDao resultDao;

    @Override
    public Report getResultReport() {
        return resultDao.getReport();
    }

    @Override
    public void incTrueAnswer() {
        resultDao.setTrueAnswerCounter(resultDao.getReport().getTrueAnswerCounter() + 1);
    }

    @Override
    public void incFalseAnswer() {
        resultDao.setFalseAnswerCounter(resultDao.getReport().getFalseAnswerCounter() + 1);
    }

    @Autowired
    public ResultServiceImpl(ResultDao resultDao) {
        this.resultDao = resultDao;
    }
}
