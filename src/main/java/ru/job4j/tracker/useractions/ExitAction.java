package ru.job4j.tracker.useractions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.useractions.UserAction;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
