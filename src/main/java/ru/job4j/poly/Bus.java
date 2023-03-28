package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
    }

    @Override
    public int passengers(int count) {
        return 0;
    }

    @Override
    public double refuel(int fuelAmount) {
        return 0;
    }
}
