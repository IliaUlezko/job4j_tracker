package ru.job4j.oop;

public class Railtrain implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по рельсам.");
    }
}

