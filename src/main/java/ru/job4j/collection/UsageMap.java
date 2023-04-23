package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("qwerty@qwerty.com", "Qwerty Qwertovich");
        hashMap.put("qwerty@qwerty.com", "Yttrewq Qwertovich");
        hashMap.put("ytrewq@ytrewq.com", "Currentname Namovich");
        hashMap.put("ytrewq@ytrewq.com", "Nextname Namovich");
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
