package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book stihi = new Book("Бородино", 45);
        Book rasskaz = new Book("Пиковая дама", 57);
        Book comics = new Book("Batman", 12);
        Book book = new Book("Clean code", 200);

        Book[] books = new Book[4];
        books[0] = stihi;
        books[1] = rasskaz;
        books[2] = comics;
        books[3] = book;

        for (Book b : books) {
            System.out.println("Книга " + b.getName() + " - " + b.getCount() + " страниц.");
        }

        System.out.println();
        books[0] = book;
        books[3] = stihi;

        for (Book b : books) {
            System.out.println("Книга " + b.getName() + " - " + b.getCount() + " страниц.");
        }

        System.out.println();
        for (Book b : books) {
            if ("Clean code".equals(b.getName())) {
                System.out.println(b.getName());
            }
        }
    }
}
