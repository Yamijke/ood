package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("The bus is driving");
    }

    @Override
    public void passengers(int count) {
        System.out.println("The bus is carrying " + count + " + passengers");
    }

    @Override
    public double refuel(int fuelAmount) {
        int fuelPrice = fuelAmount * 50;
        System.out.println("Refuel " + fuelAmount + " is cost " + fuelPrice);
        return fuelPrice;
    }
}
