package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Part = o1.split("/");
        String[] o2Part = o2.split("/");
        int o1o2PartsComparision = o2Part[0].compareTo(o1Part[0]);
        if (o1o2PartsComparision != 0) {
            return o1o2PartsComparision;
        } else {
            for (int i = 1; i < Math.min(o1Part.length, o2Part.length); i++) {
                int partNextCom = o1Part[i].compareTo(o2Part[i]);
                if (partNextCom != 0) {
                    return partNextCom;
                }
            }
        }
        return Integer.compare(o1Part.length, o2Part.length);
    }
}
