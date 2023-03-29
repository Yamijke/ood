package ru.job4j.cast;

public class Bus implements Venicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves on roads");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " has a medium speed");
    }
}
