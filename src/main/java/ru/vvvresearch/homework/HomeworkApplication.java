package ru.vvvresearch.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vvvresearch.homework.runners.ConsoleRunner;


@SpringBootApplication
public class HomeworkApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(HomeworkApplication.class, args);


    }

}
