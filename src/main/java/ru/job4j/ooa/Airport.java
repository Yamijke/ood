package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        Airbus airbus = new Airbus("A320");
        Airbus airbus1 = new Airbus("A321");
        airbus.printModel();
        airbus.printCountEngine();
        airbus1.printModel();
        airbus1.printCountEngine();
    }
}
