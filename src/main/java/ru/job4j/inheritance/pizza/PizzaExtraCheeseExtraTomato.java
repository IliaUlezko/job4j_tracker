package ru.job4j.inheritance.pizza;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public String name() {
        return super.name() + " and some tomato!";
    }
}
