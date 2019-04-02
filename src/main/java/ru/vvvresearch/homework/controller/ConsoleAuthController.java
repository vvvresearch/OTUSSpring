package ru.vvvresearch.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import ru.vvvresearch.homework.service.AuthService;

import java.util.Scanner;

@Controller
public class ConsoleAuthController implements AuthController {
    private final AuthService authService;
    private final MessageSource messageSource;

    @Autowired
    public ConsoleAuthController(AuthService authService, MessageSource messageSource) {
        this.authService = authService;
        this.messageSource = messageSource;
    }

    @Override
    public void askAuthData() {
        Scanner in = new Scanner(System.in);
        System.out.println(messageSource.getMessage("ask.name", null, null, null));
        String name = in.next();
        System.out.println(messageSource.getMessage("ask.sirname", null, null, null));
        String sirName = in.next();
        authService.setAuthData(sirName, name);
    }

}
