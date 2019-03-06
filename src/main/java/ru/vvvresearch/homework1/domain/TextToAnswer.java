package ru.vvvresearch.homework1.domain;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class TextToAnswer extends AbstractCsvConverter {
    @Override
    public Object convertToRead(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

        String[] split = s.split("\\`");
        if (split.length != 2)
            throw new CsvDataTypeMismatchException("String in CSV is not valid. Letter \' ` \' is not presented or more then one ");

        if (!split[1].toLowerCase().equals("true") && !split[1].toLowerCase().equals("false"))
            throw new CsvDataTypeMismatchException("String in CSV is not valid. After letter \' ` \' must be true or false ");
        return new Answer(split[0], split[1].toLowerCase().equals("true"));

    }
}
