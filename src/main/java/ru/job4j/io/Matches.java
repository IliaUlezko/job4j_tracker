package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            boolean check = (matches > 0 && matches < 4) && matches < count;
            if (check) {
                turn = !turn;
                count -= matches;
                String report = switch (count) {
                    case 1 -> "спичка";
                    case 2, 3, 4 -> "спички";
                    default -> "спичек";
                };
                System.out.println("Осталось " + count + " " + report + ".Ход следующего игрока.");
            } else if (count == matches) {
                System.out.println("Игра закончена!");
                break;
            } else {
                System.out.println("Ошибка!");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}