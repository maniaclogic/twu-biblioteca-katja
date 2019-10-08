package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {

    public String greet() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }


    public String display() {
        return "\n\nOptions:\n 1) List of Books \n 2) Check-out Book";

    }

    public static void navigate(String choice) throws Exception {

        Helper reader = new Helper();
        ArrayList listBooks = reader.read();

        if (choice.equals("exit") || choice.equals("x")) {

             BibliotecaApp.exit = true;

        } else if (choice.equals("1") || choice.equals("list of books")) {

            for (Object book : listBooks) System.out.println(book);
        }
        else if (choice.equals("2") || choice.equals("check-out book")){

            String bookName = Helper.userSelection("Enter the name of the book you want to check-out. Please be aware of spelling.");
            final ArrayList checkout = BibliotecaApp.checkout(bookName, listBooks);

        }
        else System.out.println("Not a valid input.");
}}
