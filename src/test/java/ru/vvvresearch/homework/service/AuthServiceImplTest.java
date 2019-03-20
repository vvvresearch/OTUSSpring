package ru.vvvresearch.homework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vvvresearch.homework.dao.PersonDao;
import ru.vvvresearch.homework.dao.PersonDaoFromStrings;
import ru.vvvresearch.homework.domain.Person;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AuthServiceImplTest {
    PersonDao personDao;
    AuthService authService;
    Person person;

    @BeforeEach
    void init() {
        personDao = mock(PersonDaoFromStrings.class);
        person = new Person("Ivanov", "Ivan");
        authService = new AuthServiceImpl(personDao);

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
        when(personDao.getPerson()).thenReturn(person);
        assertEquals(authService.getStudent(), person);
    }
}