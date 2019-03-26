package ru.vvvresearch.homework.domain;

public class Report {
    private int trueAnswerCounter;
    private int falseAnswerCounter;

    public int getTrueAnswerCounter() {
        return trueAnswerCounter;
    }

    public void setTrueAnswerCounter(int trueAnswerCounter) {
        this.trueAnswerCounter = trueAnswerCounter;
    }

    public int getFalseAnswerCounter() {
        return falseAnswerCounter;
    }

    public void setFalseAnswerCounter(int falseAnswerCounter) {
        this.falseAnswerCounter = falseAnswerCounter;
    }

    public Report() {
        trueAnswerCounter = 0;
        falseAnswerCounter = 0;
    }
}
