package ru.vvvresearch.homework1.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import ru.vvvresearch.homework1.domain.Question;
import ru.vvvresearch.homework1.domain.QuestionFromCSV;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class QuestionDaoFromCSV implements QuestionDao {

    private String csvFileName;

    @Override
    public List<Question> getQuestions() throws FileNotFoundException {
        InputStream inputStream = this.getClass().getResourceAsStream(csvFileName);
        if (inputStream == null)
            throw new FileNotFoundException("CSV file is not found. Please check your filepath to questions data");
        Reader reader = new InputStreamReader(inputStream);

        List<Question> beans = new CsvToBeanBuilder(reader).withType(QuestionFromCSV.class).build().parse();
        return beans;
    }

    public QuestionDaoFromCSV(String csvFileName) {
        this.csvFileName = csvFileName;
    }
}
