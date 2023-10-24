package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNIsNegative() {
        Fact f = new Fact();
        f.calc(-4);
    }

    @Test
    public void whenNIs5() {
        Fact f = new Fact();
        int result = f.calc(5);
        int expected = 120;
        assertEquals(expected, result);
    }
}