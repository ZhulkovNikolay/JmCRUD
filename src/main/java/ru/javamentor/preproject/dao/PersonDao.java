package ru.javamentor.preproject.dao;

import org.springframework.stereotype.Component;
import ru.javamentor.preproject.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ann", 11,"ann@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 22, "bob@eritrea.cc"));
        people.add(new Person(++PEOPLE_COUNT, "Clark", 33, "clark@zimpost.co.zw"));
        people.add(new Person(++PEOPLE_COUNT, "David", 44, "david@yandex.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(u -> u.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
