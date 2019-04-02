package ru.vvvresearch.homework.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.vvvresearch.homework.runners.ConsoleRunner;
import ru.vvvresearch.homework.service.AuthService;

import java.util.Locale;

@ShellComponent
public class RunShellCommands {
    private final ConsoleRunner consoleRunner;
    private final Locale locale;
    private final AuthService authService;

    @Autowired
    public RunShellCommands(ConsoleRunner consoleRunner, Locale locale, AuthService authService) {
        this.consoleRunner = consoleRunner;
        this.locale = locale;
        this.authService = authService;
    }

    @ShellMethod("Run testing user")
    public void run(@ShellOption String name, @ShellOption String sirname) throws Exception {
        authService.setAuthData(sirname, name);
        consoleRunner.run(null);
    }

}
