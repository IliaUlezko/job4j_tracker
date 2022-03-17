package ru.job4j.tracker.useractions;

import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.useractions.UserAction;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
        return true;
    }
}
