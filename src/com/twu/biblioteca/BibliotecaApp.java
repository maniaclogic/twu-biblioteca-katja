package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public static boolean exit = false;


    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();

        System.out.println(menu.greet());

        while (!exit) {
            System.out.println(menu.display());
            menu.navigate(menu.userSelection());
        }
    }
}
