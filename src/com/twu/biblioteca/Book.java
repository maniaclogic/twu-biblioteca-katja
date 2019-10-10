package com.twu.biblioteca;

import java.util.ArrayList;

public class Book implements Media {
    private String name;
    private String author;
    private int year;
    private boolean checkedOut = false;
    public static ArrayList<Book> instances = new ArrayList<Book>();

    Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    Book(String bookInfo) {
        String[] parts = bookInfo.split("; ");
        String[] parts2 = parts[1].split(" \\(");
        this.name = parts[0];
        this.author = parts2[0];
        this.year = Integer.parseInt(parts2[1].split("\\)")[0]);
    }

    public static Book createBook(String name, String author, int year) {
        Book book = new Book(name, author, year);
        instances.add(book);
        return book;
    }

    public static Book createBook(String bookInfo) {
        Book book = new Book(bookInfo);
        instances.add(book);
        return book;
    }

    public String getName() { return this.name; }

    public String getAuthor() { return this.author; }

    public int getYear() { return this.year; }

    public boolean checkoutStatus() { return this.checkedOut; }

    public static ArrayList<Book> getInstances() { return instances; }

    @Override
    public void checkOut() {
        this.checkedOut = true;
    }

    public void returnBook() {

        this.checkedOut = false;
    }

    public String toString() {

        return this.getName() +"; "+ this.getAuthor() +" "+ this.getYear();
    }

}

