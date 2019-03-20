package ru.vvvresearch.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vvvresearch.homework.dao.QuestionDao;
import ru.vvvresearch.homework.domain.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;
    private final ResultService resultService;
    private Iterator<Question> iterator;
    private Question question;



    @Autowired
    public QuestionServiceImpl(QuestionDao question, ResultService resultService) throws IOException {
        this.questionDao = question;
        this.resultService = resultService;
        iterator = questionDao.getQuestions().iterator();
    }

    @Override
    public boolean checkAnswer(int numberOfAnswer) {
        for (int i = 0; i < question.getAnswers().size(); i++) {
            if(question.getAnswers().get(i).isTrueAnswer() && numberOfAnswer == i) {
                resultService.incTrueAnswer();
                return true;
            }
        }
        resultService.incFalseAnswer();
        return false;
    }

    @Override
    public String getQuestion() {
        question = iterator.next();
        return question.getQuestion();
    }

    @Override
    public List<String> getAnswers() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < question.getAnswers().size(); i++) {
            list.add(question.getAnswers().get(i).getAnswer());
        }
        return list;
    }

    @Override
    public boolean hasNextQuestion() {
        return iterator.hasNext();
    }
}
