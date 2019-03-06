package ru.vvvresearch.homework1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vvvresearch.homework1.service.QuestionService;


public class Homework1Application {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        questionService.runTesting();
    }

}
