package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public String greet() {
       return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
    }

    public static void main(String[] args) throws Exception {

        BibliotecaApp app = new BibliotecaApp();
        Menu menu = new Menu();

        System.out.println(app.greet());
        System.out.println(menu.display());
        menu.navigate();
    }
}
