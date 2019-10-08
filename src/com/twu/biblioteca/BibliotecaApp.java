package com.twu.biblioteca;


public class BibliotecaApp {

    public String greet() {
       return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public static void main(String[] args) {

        BibliotecaApp app = new BibliotecaApp();

        System.out.println(app.greet());
    }
}
