package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> nameCmpr = person -> key.contains(person.getName());
        Predicate<Person> surnameCmpr = person -> key.contains(person.getSurname());
        Predicate<Person> phoneCmpr = person -> key.contains(person.getPhone());
        Predicate<Person> addressCmpr = person -> key.contains(person.getAddress());
        Predicate<Person> combineCmpr = nameCmpr.or(surnameCmpr.or(
                phoneCmpr.or(addressCmpr)));
        for (var person : persons) {
            if (combineCmpr.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}