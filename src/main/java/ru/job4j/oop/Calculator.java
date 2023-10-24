package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = Calculator.sum(10);
        System.out.println(result);
        System.out.println(calculator.multiply(12));
        System.out.println(minus(22));
        System.out.println(calculator.divide(10));
        System.out.println(calculator.sumAllOperation(10));
    }
}
