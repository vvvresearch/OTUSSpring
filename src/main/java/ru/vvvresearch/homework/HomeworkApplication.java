package ru.vvvresearch.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.vvvresearch.homework.config.BeansConfiguration;
import ru.vvvresearch.homework.controller.AuthController;
import ru.vvvresearch.homework.controller.ConsoleQuestionController;
import ru.vvvresearch.homework.controller.QuestionController;
import ru.vvvresearch.homework.controller.ReportController;
import ru.vvvresearch.homework.service.QuestionService;

@Configuration
@ComponentScan
public class HomeworkApplication {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        AuthController authController = context.getBean(AuthController.class);
        authController.askAuthData();
        QuestionController questionController = context.getBean(QuestionController.class);
        questionController.runTest();
        ReportController reportController = context.getBean(ReportController.class);
        reportController.showResult();

    }

}
