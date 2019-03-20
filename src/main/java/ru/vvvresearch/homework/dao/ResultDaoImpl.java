package ru.vvvresearch.homework.dao;

import org.springframework.stereotype.Repository;
import ru.vvvresearch.homework.domain.Report;
@Repository
public class ResultDaoImpl implements ResultDao {
    Report report;
    @Override
    public Report getReport() {
        return report;
    }

    @Override
    public void setTrueAnswerCounter(int counter) {
        report.setTrueAnswerCounter(counter);
    }

    @Override
    public void setFalseAnswerCounter(int counter) {
        report.setFalseAnswerCounter(counter);
    }

    public ResultDaoImpl() {
        report = new Report();
    }
}
