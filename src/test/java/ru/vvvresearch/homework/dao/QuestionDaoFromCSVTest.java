package ru.vvvresearch.homework.dao;

import org.assertj.core.api.Assertions;

import static org.assertj.core.groups.Tuple.tuple;

import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;
import ru.vvvresearch.homework.domain.Answer;
import ru.vvvresearch.homework.util.SimpleMessageSource;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class QuestionDaoFromCSVTest {

    @Test
    void getQuestions() {
        MessageSource messageSource = mock(SimpleMessageSource.class);
        when(messageSource.getMessage("csvfilename.key", null, null, null)).thenReturn("unknown.csv", "/testdata/test.csv");
        final QuestionDao questionDao = new QuestionDaoFromCSV(messageSource);
        Throwable throwable = assertThrows(FileNotFoundException.class, () -> questionDao.getQuestions());
        assertEquals("CSV file is not found. Please check your filepath to questions data", throwable.getMessage());
        final QuestionDao questionDao2 = new QuestionDaoFromCSV(messageSource);
        try {
            assertNotNull(questionDao2.getQuestions());
            assertEquals(questionDao2.getQuestions().get(0).getQuestion(), "test?");
            Assertions.assertThat(questionDao2.getQuestions().get(0).getAnswers())
                    .extracting(Answer::getAnswer, Answer::isTrueAnswer)
                    .containsExactly(
                            tuple("1", true),
                            tuple("2", false),
                            tuple("3", false),
                            tuple("4", false)
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}