package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] lef = left.split("\\.");
        String[] righ = right.split("\\.");
        int leftN = Integer.parseInt(lef[0]);
        int righN = Integer.parseInt(righ[0]);
        return Integer.compare(leftN, righN);
    }
}
