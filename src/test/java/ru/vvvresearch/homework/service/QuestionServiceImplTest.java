package ru.vvvresearch.homework.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.vvvresearch.homework.dao.QuestionDao;
import ru.vvvresearch.homework.dao.QuestionDaoFromCSV;
import ru.vvvresearch.homework.dao.ResultDao;
import ru.vvvresearch.homework.domain.Answer;
import ru.vvvresearch.homework.domain.Person;
import ru.vvvresearch.homework.domain.Question;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuestionServiceImplTest {
    QuestionDao questionDao;
    ResultService resultService;
    List<Question> list;

    @BeforeEach
    void init() throws IOException {
        list = new ArrayList<>();
        list.add(new Question() {
            @Override
            public String getQuestion() {
                return "test";
            }

            @Override
            public List<Answer> getAnswers() {
                return Arrays.asList(
                        new Answer("0", true),
                        new Answer("1", false));
            }
        });
        questionDao = mock(QuestionDaoFromCSV.class);
        resultService = mock(ResultServiceImpl.class);
        when(questionDao.getQuestions()).thenReturn(list);
    }

    @Test
    void checkAnswer() throws IOException {
        QuestionService questionService = new QuestionServiceImpl(questionDao, resultService);
        questionService.getQuestion();//init iterator and current field question
        assertTrue(questionService.checkAnswer(0));
        assertFalse(questionService.checkAnswer(1));
    }

    @Test
    void getQuestion() throws IOException {
        QuestionService questionService = new QuestionServiceImpl(questionDao, resultService);
        assertEquals(questionService.getQuestion(),"test");
    }

    @Test
    void getAnswers() throws IOException {
       final QuestionService questionService = new QuestionServiceImpl(questionDao, resultService);
        questionService.getQuestion();//init iterator and current field question
        for (int i = 0; i < 2; i++) {
            Assertions.assertThat(questionService.getAnswers().get(i)).isEqualTo(Integer.toString(i));
        }
    }

    @Test
    void hasNextQuestion() throws IOException {
        final QuestionService questionService = new QuestionServiceImpl(questionDao, resultService);
        assertTrue(questionService.hasNextQuestion());
        questionService.getQuestion();
        assertFalse(questionService.hasNextQuestion());
    }
}