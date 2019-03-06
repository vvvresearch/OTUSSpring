package ru.vvvresearch.homework1.service;

import ru.vvvresearch.homework1.dao.QuestionDao;
import ru.vvvresearch.homework1.domain.Answer;
import ru.vvvresearch.homework1.domain.Question;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class ConsoleQuestionService implements QuestionService {
    private final QuestionDao question;

    @Override
    public void runTesting() {
        int counterTrueAnswer = 0;
        int counterFalseAnswer = 0;
        int trueAnswer = 0;
        Scanner in = new Scanner(System.in);
        try {
            Iterator<Question> iterator = question.getQuestions().iterator();
            while (iterator.hasNext()) {
                Question question = iterator.next();
                System.out.println(question.getQuestion());
                for (int i = 0; i < question.getAnswers().size(); i++) {
                    System.out.println((i + 1) + ". " + question.getAnswers().get(i).getAnswer());
                    if (question.getAnswers().get(i).isTrueAnswer())
                        trueAnswer = i;
                }
                System.out.print("What is true answer?");
                if (in.nextInt() == trueAnswer + 1)
                    counterTrueAnswer++;
                else
                    counterFalseAnswer++;
            }
            in.close();
            System.out.println(
                    new StringBuilder()
                            .append("Results\n True answer:")
                            .append(counterTrueAnswer)
                            .append("\n False answer:")
                            .append(counterFalseAnswer)
                            .append("\n Total: ")
                            .append(counterFalseAnswer + counterTrueAnswer)
                            .toString());
        } catch (IOException e) {
            in.close();
            e.printStackTrace();
        }
    }

    public ConsoleQuestionService(QuestionDao question) {
        this.question = question;
    }
}
