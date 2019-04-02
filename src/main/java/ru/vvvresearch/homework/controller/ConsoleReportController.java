package ru.vvvresearch.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import ru.vvvresearch.homework.service.ResultService;

@Controller
public class ConsoleReportController implements ReportController {
    private final MessageSource messageSource;
    private ResultService resultService;

    @Override
    public void showResult() {
        int cFalse = resultService.getResultReport().getFalseAnswerCounter();
        int cTrue = resultService.getResultReport().getTrueAnswerCounter();
        System.out.println(
                new StringBuilder()
                        .append(messageSource.getMessage("report.result",null,null,null))
                        .append(":\n  ")
                        .append(messageSource.getMessage("true.answer.count",null,null,null))
                        .append(" ")
                        .append(cTrue)
                        .append("\n  ")
                        .append(messageSource.getMessage("false.answer.count",null,null,null))
                        .append(" ")
                        .append(cFalse)
                        .append("\n  ")
                        .append(messageSource.getMessage("total.answer.count",null,null,null))
                        .append(" ")
                        .append(cTrue + cFalse)
                        .append(" ")
                        .toString());

    }

    @Autowired
    public ConsoleReportController(ResultService resultService, MessageSource messageSource) {
        this.resultService = resultService;
        this.messageSource = messageSource;
    }
}
