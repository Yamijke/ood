package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Lion King", 500);
        Book book2 = new Book("War and peace", 3000);
        Book book3 = new Book("Clean code", 404);
        Book book4 = new Book("Some book", 300);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book bo : books) {
            System.out.println(bo.getName() + " has " + bo.getCount() + " pages ");
        }
        System.out.println("Swap first and last books");
        books[0] = book4;
        books[3] = book1;
        for (Book bo : books) {
            System.out.println(bo.getName() + " has " + bo.getCount() + " pages ");
        }
        System.out.println("Show book with name Clean code");
        for (Book bo : books) {
            if (bo.getName().equals("Clean code")) {
                System.out.println(bo.getName() + " has " + bo.getCount() + " pages ");
            }
        }
    }
}
