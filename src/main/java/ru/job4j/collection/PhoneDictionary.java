package ru.job4j.collection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> getName = name -> name.getName().contains(key);
        Predicate<Person> getPhone = name -> name.getPhone().contains(key);
        Predicate<Person> getAddress = name -> name.getAddress().contains(key);
        Predicate<Person> getSurname = name -> name.getSurname().contains(key);
        var combine = getName.or(getPhone).or(getAddress).or(getSurname);
        var result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
