package com.twu.biblioteca;


public class BibliotecaApp {

    static boolean exit = false;

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        Helper.readBooks("/Users/katben/Documents/TWU_Biblioteca-master/src/com/twu/biblioteca/bookList.txt");
        Helper.readMovies("/Users/katben/Documents/TWU_Biblioteca-master/src/com/twu/biblioteca/movielist.txt");

        User user2 = User.createUser("123-1234", "1234", "Tommy", "0149-6698584", "jfh@jdhs.com");
        User user3 = User.createUser("123-4567", "1234", "Jon", "948372938272", "jfu@dosmw.com");

        System.out.println(menu.greet());

        while (!exit) {
            System.out.println(menu.display());
            menu.navigate(Helper.userSelection("Input the number of what you want to do.   (x to quit)"));
        }
    }
}