package ru.job4j.collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNum1And1Dot3And5() {
        String[] input = {
                "5. Task.",
                "1. Task.",
                "1.3. Task."
        };
        String[] out = {
                "1. Task.",
                "1.3. Task.",
                "5. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}