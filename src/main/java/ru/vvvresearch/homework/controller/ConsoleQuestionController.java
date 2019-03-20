package ru.vvvresearch.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import ru.vvvresearch.homework.service.QuestionService;

import java.util.InputMismatchException;
import java.util.Scanner;

@Controller
public class ConsoleQuestionController implements QuestionController {
    private final QuestionService questionService;
    private final MessageSource messageSource;

    @Override
    public void runTest() {
        Scanner inn = new Scanner(System.in);
        while (questionService.hasNextQuestion()) {
            System.out.println(questionService.getQuestion());
            for (int i = 0; i < questionService.getAnswers().size(); i++) {
                System.out.println(i + ". " + questionService.getAnswers().get(i));
            }
            System.out.print(messageSource.getMessage("prompt.question", null, null, null));
            do {
                String s = inn.nextLine();
                if (s.toLowerCase().equals("exit"))
                    break;
                try {
                    questionService.checkAnswer(Integer.parseInt(s));
                    break;
                }
                catch (NumberFormatException e){
                    System.out.print(messageSource.getMessage("error.input", null, null, null));
                }
            }while (true);
        }

    }

    @Autowired
    public ConsoleQuestionController(QuestionService questionService, MessageSource messageSource) {
        this.questionService = questionService;
        this.messageSource = messageSource;
    }
}
