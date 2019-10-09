package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static com.twu.biblioteca.Book.instances;

public class Menu {

    public String greet() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }


    public String display() {
        return "\n\nOptions:\n 1) List of Books \n 2) Check-out Book";

    }

    public static void navigate(String choice) throws Exception {

        if (choice.equals("exit") || choice.equals("x")) {

            BibliotecaApp.exit = true;

        } else if (choice.equals("1") || choice.equals("list of books")) {

            ArrayList<Book> listBook = Book.getInstances();
            for (Book book : listBook) {
                if (!book.checkoutStatus()) {
                    System.out.println(book.toString());
                }
        }
        }
        else if (choice.equals("2") || choice.equals("check-out book")){

            String desiredBook = Helper.userSelection("Enter the name of the book you want to check-out. Please be aware of spelling.");
            ArrayList<Book> listBook = Book.getInstances();
            Book checkedBook = null;
            for (Book book : listBook) {
                if (book.getName().equals(desiredBook)) {

                    checkedBook = book;

                }
            }
            if (checkedBook != null) {
                Book.instances.remove(checkedBook);
                checkedBook.checkOut();
                System.out.println(checkedBook.getName());
                System.out.println("-- Has successfully been checked out.");
                Book.instances.add(checkedBook);
            }
        }
        else System.out.println("Not a valid input.");
}}
