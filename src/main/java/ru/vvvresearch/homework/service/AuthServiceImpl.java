package ru.vvvresearch.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vvvresearch.homework.dao.PersonDao;
import ru.vvvresearch.homework.domain.Person;

@Service
public class AuthServiceImpl implements AuthService {
    private PersonDao personDao;

    @Override
    public void setAuthData(String sirName, String name) {
        personDao.setPersonFromString(sirName,name);

    }

    @Override
    public Person getStudent() {
        return personDao.getPerson();
    }

    @Autowired
    public AuthServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }
}
