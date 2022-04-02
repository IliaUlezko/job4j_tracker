package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        names.put("ivanov@gmail.com", "Ivanov Ivan Ivanovich");
        for (String key : names.keySet()) {
            String value = names.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
