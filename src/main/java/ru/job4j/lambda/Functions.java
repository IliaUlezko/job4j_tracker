package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Functions {
    public static List<Double> diapason(
            int start, int finish, Function<Double, Double> func
    ) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < finish; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }
}
