package com.twu.biblioteca;


import java.util.ArrayList;

public class BibliotecaApp {

    public static boolean exit = false;


    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();

        System.out.println(menu.greet());

        while (!exit) {
            System.out.println(menu.display());
            Menu.navigate(Helper.userSelection("Input the number or name of what you want to do.   (Type x or exit to quit)"));
        }
    }

    public static ArrayList<String> checkout(String name, ArrayList<String> books) throws Exception {

        books.remove(name);
        return books;

    }
    // string at position = contains(inputString) - find index in array
    // ask whether it is correct
    // delete string - pop index from list
}
