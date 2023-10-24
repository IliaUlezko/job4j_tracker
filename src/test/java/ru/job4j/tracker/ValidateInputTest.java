package ru.job4j.tracker;

import ru.job4j.tracker.output.*;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        List<String> list = List.of("one", "1");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        List<String> list = List.of("1");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleValidInput() {
        Output out = new StubOutput();
        List<String> list = List.of("1", "2", "3");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1, is(2));
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2, is(3));
    }

    @Test
    public void whenNegativeInvalidInput() {
        Output out = new StubOutput();
        List<String> list = List.of("-1", "1");
        Input in = new StubInput(list);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}