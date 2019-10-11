package com.twu.biblioteca;

import java.util.ArrayList;

public class Book implements Media {
    private String name;
    private String author;
    private int year;
    private boolean checkedOut = false;
    static ArrayList<Book> instances = new ArrayList<Book>();

    private Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    private Book(String bookInfo) {
        String[] parts = bookInfo.split("; ");
        String[] parts2 = parts[1].split(" \\(");
        this.name = parts[0];
        this.author = parts2[0];
        this.year = Integer.parseInt(parts2[1].split("\\)")[0]);
    }

    static Book createBook(String name, String author, int year) {
        Book book = new Book(name, author, year);
        instances.add(book);
        return book;
    }

    static Book createBook(String bookInfo) {
        Book book = new Book(bookInfo);
        instances.add(book);
        return book;
    }

    String getName() { return this.name; }

    String getAuthor() { return this.author; }

    int getYear() { return this.year; }

    boolean checkoutStatus() { return this.checkedOut; }

    static ArrayList<Book> getInstances() { return instances; }

    @Override
    public void checkOut() {
        this.checkedOut = true;
    }

    void returnBook() {

        this.checkedOut = false;
    }

    public String toString() {

        return this.getName() +"; "+ this.getAuthor() +" "+ this.getYear();
    }

}

