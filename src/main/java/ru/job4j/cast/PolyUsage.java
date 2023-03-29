package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Venicle airplane = new Airplane();
        Venicle train = new Train();
        Venicle bus = new Bus();

        Venicle[] venicles = new Venicle[]{airplane, train, bus};
        for (Venicle a: venicles) {
            a.move();
            a.speed();
        }
    }
}
