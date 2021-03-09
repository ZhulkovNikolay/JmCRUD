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
        people.add(new Person(++PEOPLE_COUNT, "Ann", 11));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 22));
        people.add(new Person(++PEOPLE_COUNT, "Clark", 33));
        people.add(new Person(++PEOPLE_COUNT, "David", 44));
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

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
