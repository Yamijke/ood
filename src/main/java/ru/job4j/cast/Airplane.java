package ru.job4j.cast;

public class Airplane implements Venicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves through the air");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " has a very high speed");
    }
}
