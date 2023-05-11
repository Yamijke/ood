package ru.job4j.atests;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr"
        );
        Consumer<String> consumer = System.out::println;
        names.forEach(consumer);
    }
}
