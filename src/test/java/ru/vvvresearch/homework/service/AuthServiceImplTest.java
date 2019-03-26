package ru.vvvresearch.homework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vvvresearch.homework.dao.PersonDao;
import ru.vvvresearch.homework.dao.PersonDaoFromStrings;
import ru.vvvresearch.homework.domain.Person;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class AuthServiceImplTest {
    PersonDao personDao;
    @Autowired
    AuthService authService;
    Person person;

    @BeforeEach
    void init() {
        personDao = mock(PersonDaoFromStrings.class);
        person = new Person("Ivanov", "Ivan");
    }

    @Test
    void setAuthData() {
        authService.setAuthData("Petrov", "Petr");
        when(personDao.getPerson()).thenReturn(new Person("Petrov", "Petr"));
        assertThat(authService.getStudent())
                .extracting(Person::getName)
                .isEqualTo("Petr");
        assertThat(authService.getStudent())
                .extracting(Person::getSirname)
                .isEqualTo("Petrov");
        //when(personDao.getPerson()).thenReturn(new Person())
    }

    @Test
    void getStudent() {
        authService.setAuthData("Petrov", "Petr");
        assertEquals(authService.getStudent().getSirname(), "Petrov");
        assertEquals(authService.getStudent().getName(), "Petr");
    }
}