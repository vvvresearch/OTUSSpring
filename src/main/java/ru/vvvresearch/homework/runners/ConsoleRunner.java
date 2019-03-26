package ru.vvvresearch.homework.runners;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vvvresearch.homework.config.YamlProps;
import ru.vvvresearch.homework.controller.AuthController;
import ru.vvvresearch.homework.controller.QuestionController;
import ru.vvvresearch.homework.controller.ReportController;

@Component
public class ConsoleRunner {
    private final AuthController authController;
    private final QuestionController questionController;
    private final ReportController reportController;
    private final YamlProps yamlProps;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConsoleRunner.class);
    @Autowired
    public ConsoleRunner(AuthController authController, QuestionController questionController, ReportController reportController, YamlProps yamlProps) {
        this.authController = authController;
        this.questionController = questionController;
        this.reportController = reportController;
        this.yamlProps = yamlProps;
    }


    public void run(String... args) throws Exception {
        logger.info("Country props: {}",yamlProps.getCountry());
        logger.info("Locale props: {}",yamlProps.getLocale());
        authController.askAuthData();
        questionController.runTest();
        reportController.showResult();
    }
}
