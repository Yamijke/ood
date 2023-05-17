package ru.job4j.atests;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Consumer<String> consumer = s -> list.add(s);
        consumer.accept("one");
        consumer.accept("two");
        consumer.accept("three");
        consumer.accept("four");
        consumer.accept("five");
        consumer.accept("six");
        consumer.accept("seven");

        Predicate<String> pred = s -> s.length() % 2 == 0;
        for (String s : list) {
            if (pred.test(s)) {
                System.out.println("value " + s);
            }
        }
        /*
            Заменить создание нового ArrayList из исходного списка на Supplier, объявлен ниже,
            требуется его реализовать.
         */
        Supplier<List<String>> sup = () -> new ArrayList<>(list);
        List<String> newList = new ArrayList<>(list);

        Function<String, String> func = s -> s.toUpperCase();
        Consumer<String> con = s -> System.out.println(s);
        for (String s : newList) {
            con.accept(func.apply(s));
            System.out.println(s.toUpperCase());
        }
    }
}
