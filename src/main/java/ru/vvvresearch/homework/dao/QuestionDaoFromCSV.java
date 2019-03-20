package ru.vvvresearch.homework.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Repository;
import ru.vvvresearch.homework.domain.Question;
import ru.vvvresearch.homework.domain.QuestionFromCSV;

import java.io.*;
import java.util.List;

@Repository
public class QuestionDaoFromCSV implements QuestionDao {

    MessageSource messageSource;
    private String csvFileName;

    @Override
    public List<Question> getQuestions() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(csvFileName);
        if (inputStream == null)
            throw new FileNotFoundException("CSV file is not found. Please check your filepath to questions data");
        Reader reader = new InputStreamReader(inputStream);

        List<Question> beans = new CsvToBeanBuilder(reader).withType(QuestionFromCSV.class).build().parse();
        inputStream.close();
        return beans;
    }

    @Autowired
    public QuestionDaoFromCSV(MessageSource messageSource) {
        this.messageSource = messageSource;
        this.csvFileName = messageSource.getMessage("csvfilename.key",null,null,null);

    }
}
