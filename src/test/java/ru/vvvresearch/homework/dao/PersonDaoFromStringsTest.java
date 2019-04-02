package ru.vvvresearch.homework.dao;

import org.junit.jupiter.api.Test;
import ru.vvvresearch.homework.domain.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoFromStringsTest {

    @Test
    void getPerson() {
        PersonDao personDao = new PersonDaoFromStrings();
        Throwable exception = assertThrows(NullPointerException.class, () -> personDao.getPerson());
        assertEquals("Registration data is not find. Please register first.",exception.getMessage());
        personDao.setPersonFromString("Ivanov","Viktor");
        assertDoesNotThrow(()->personDao.getPerson());
        assertEquals(personDao.getPerson().getName(),"Viktor");
        assertEquals(personDao.getPerson().getSirname(),"Ivanov");
    }

    @Test
    void setPersonFromString() {
        PersonDao personDao = new PersonDaoFromStrings();
        assertDoesNotThrow(()->personDao.setPersonFromString("Ivanov","Viktor"));
        assertEquals(personDao.getPerson().getName(),"Viktor");
        assertEquals(personDao.getPerson().getSirname(),"Ivanov");
    }
}