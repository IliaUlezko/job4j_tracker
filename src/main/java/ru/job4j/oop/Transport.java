package ru.job4j.oop;

public class Transport {

    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle railtrain = new Railtrain();
        Vehicle airplane1 = new Airplane();
        Vehicle bus1 = new Bus();
        Vehicle railtrain1 = new Railtrain();

        Vehicle[] vehicles = new Vehicle[]{airplane, bus, railtrain, railtrain1, bus1, airplane1};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
