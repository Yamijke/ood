package ru.job4j.cast;

public class Train implements Venicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " moves on rails");
    }

    @Override
    public void speed() {
        System.out.println(getClass().getSimpleName() + " has a high speed");
    }
}
