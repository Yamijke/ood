package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] array = {"Sunday", "Monday", "Wednesday", "Thursday"};
            String key = "Monday";
            int index = indexOf(array, key);
            System.out.println("Index of " + key + " is " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
