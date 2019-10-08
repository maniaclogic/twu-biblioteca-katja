package com.twu.biblioteca;


public class BibliotecaApp {

    public String greet() {
       return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n\n";
    }

    public static void main(String[] args) throws Exception {

        BibliotecaApp app = new BibliotecaApp();
        BibFileReader reader = new BibFileReader();

        System.out.println(app.greet());
        System.out.println(reader.read());
    }
}
