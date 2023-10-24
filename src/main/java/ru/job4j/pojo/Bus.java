package ru.job4j.pojo;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("You drive bus.");
    }

    @Override
    public void passengers(int amount) {
        System.out.println("The bus has " + amount + " passengers.");
    }

    @Override
    public int refuel(int value) {
        int price = 50;
        return value * price;
    }
}
