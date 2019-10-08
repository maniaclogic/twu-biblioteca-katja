package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public String greet() {
       return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n\n";
    }

    public static void main(String[] args) throws Exception {

        BibliotecaApp app = new BibliotecaApp();
        BibFileReader reader = new BibFileReader();

        System.out.println(app.greet());
        ArrayList listBooks = reader.read();
        for (Object book : listBooks) System.out.println(book);
    }
}
