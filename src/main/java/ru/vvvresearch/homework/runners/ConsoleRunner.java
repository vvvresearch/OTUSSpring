package ru.vvvresearch.homework.runners;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vvvresearch.homework.controller.AuthController;
import ru.vvvresearch.homework.controller.QuestionController;
import ru.vvvresearch.homework.controller.ReportController;

import java.util.Locale;

@Component
public class ConsoleRunner {

    private final QuestionController questionController;
    private final ReportController reportController;
    private final Locale locale;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConsoleRunner.class);

    @Autowired
    public ConsoleRunner(QuestionController questionController, ReportController reportController, Locale locale) {

        this.questionController = questionController;
        this.reportController = reportController;
        this.locale = locale;
    }


    public void run(String... args) throws Exception {
        logger.info("Country props: {}", locale.getCountry());
        logger.info("Locale props: {}", locale.getLanguage());

        questionController.runTest();
        reportController.showResult();
    }
}
