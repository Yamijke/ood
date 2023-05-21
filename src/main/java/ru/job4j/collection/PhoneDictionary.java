package ru.job4j.collection;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        var getName = (Predicate<Person>) name -> name.getName().contains(key);
        var getPhone = (Predicate<Person>) name -> name.getPhone().contains(key);
        var getAddress = (Predicate<Person>) name -> name.getAddress().contains(key);
        var getSurname = (Predicate<Person>) name -> name.getSurname().contains(key);
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
