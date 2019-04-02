package ru.vvvresearch.homework.domain;

public class Answer {
    private String strAnswer;
    private boolean trueAnswer;

    public Answer(String strAnswer, boolean trueAnswer) {
        this.strAnswer = strAnswer;
        this.trueAnswer = trueAnswer;
    }

    public String getAnswer() {
        return strAnswer;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

}
