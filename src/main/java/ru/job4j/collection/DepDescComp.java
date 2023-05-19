package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Part = o1.split("/");
        String[] o2Part = o2.split("/");
        int result = o2Part[0].compareTo(o1Part[0]);
        return result != 0 ? result : o1.compareTo(o2);
    }
}
