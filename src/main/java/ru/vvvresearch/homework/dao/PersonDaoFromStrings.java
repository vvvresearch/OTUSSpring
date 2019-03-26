package ru.vvvresearch.homework.dao;

import org.springframework.stereotype.Repository;
import ru.vvvresearch.homework.domain.Person;
@Repository
public class PersonDaoFromStrings implements PersonDao {
    private Person person;

    @Override
    public Person getPerson() throws NullPointerException {
        if (person == null) {
            throw new NullPointerException("Registration data is not find. Please register first.");
        }
        return person;
    }

    @Override
    public void setPersonFromString(String sirName, String name) {
        person = new Person(sirName,name);
    }

}
