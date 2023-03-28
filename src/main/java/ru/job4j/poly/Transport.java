package ru.job4j.poly;

public interface Transport {
    void drive();

    int passengers(int count);

    double refuel(int fuelAmount);
}
