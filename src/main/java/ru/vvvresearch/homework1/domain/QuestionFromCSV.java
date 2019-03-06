package ru.vvvresearch.homework1.domain;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import java.util.List;

public class QuestionFromCSV extends Question{

    @CsvBindByName(column = "Question", required = true)
    private String question;

    @CsvBindAndSplitByName(column = "Answers", required = true, elementType = Answer.class, splitOn = "\\|", converter = TextToAnswer.class)
    private List<Answer> answers;

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public List<Answer> getAnswers() {
        return answers;
    }
}
