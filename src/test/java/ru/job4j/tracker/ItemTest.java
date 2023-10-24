package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ItemTest {

    @Test
    public void whenCompareToAsc() {
        List<Item> items = Arrays.asList(
                new Item("phone", 1),
                new Item("milk", 2),
                new Item("flower", 3)
        );
        List<Item> expected = Arrays.asList(
                new Item("flower", 3),
                new Item("milk", 2),
                new Item("phone", 1)
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }

    @Test
    public void whenCompareToAscMultiply() {
        List<Item> items = Arrays.asList(
                new Item("phone", 1),
                new Item("milk", 2),
                new Item("flower", 3),
                new Item("sugar", 4),
                new Item("salt", 5),
                new Item("water", 6)
        );
        List<Item> expected = Arrays.asList(
                new Item("flower", 3),
                new Item("milk", 2),
                new Item("phone", 1),
                new Item("salt", 5),
                new Item("sugar", 4),
                new Item("water", 6)
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }

    @Test
    public void whenCompareToDesc() {
        List<Item> items = Arrays.asList(
                new Item("milk", 1),
                new Item("phone", 2),
                new Item("flower", 3)
        );
        List<Item> expected = Arrays.asList(
                new Item("phone", 2),
                new Item("milk", 1),
                new Item("flower", 3)
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }

    @Test
    public void whenCompareToDescMultiply() {
        List<Item> items = Arrays.asList(
                new Item("phone", 1),
                new Item("milk", 2),
                new Item("flower", 3),
                new Item("sugar", 4),
                new Item("salt", 5),
                new Item("water", 6)
        );
        List<Item> expected = Arrays.asList(
                new Item("water", 6),
                new Item("sugar", 4),
                new Item("salt", 5),
                new Item("phone", 1),
                new Item("milk", 2),
                new Item("flower", 3)
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }
}