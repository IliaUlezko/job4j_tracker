package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println("Есть ошибки?: " + active);
        System.out.println("Количество ошибок: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error(true, 2, "Fix it!");
        error1.showInfo();
        Error error2 = new Error();
        error2.showInfo();
    }
}
