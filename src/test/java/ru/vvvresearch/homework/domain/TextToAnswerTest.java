package ru.vvvresearch.homework.domain;

import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TextToAnswerTest {
    @DisplayName("Проверка convert to read")
    @Test
    void convertToRead() throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        Answer answer = mock(Answer.class);
        when(answer.getAnswer()).thenReturn("answer");
        when(answer.isTrueAnswer()).thenReturn(true);
        TextToAnswer textToAnswer = new TextToAnswer();
        assertEquals(((Answer) textToAnswer.convertToRead("answer`true")).getAnswer(), answer.getAnswer());
        assertEquals(((Answer) textToAnswer.convertToRead("answer`true")).isTrueAnswer(), answer.isTrueAnswer());
    }
}