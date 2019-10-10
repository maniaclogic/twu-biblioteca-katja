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
        return "\n\nOptions:\n 1) List of Books \n 2) Check-out Book \n 3) Return a Book \n 4) List of Movies";

    }

    public static void navigate(String choice) throws Exception {

        if (choice.equals("exit") || choice.equals("x")) {

            BibliotecaApp.exit = true;

        } else if (choice.equals("1") || choice.equals("list of books") || choice.equals("List of Books")) {

            ArrayList<Book> listBook = Book.getInstances();
            for (Book book : listBook) {
                if (!book.checkoutStatus()) {
                    System.out.println(book.toString());
                }
        }
        }
        else if (choice.equals("2") || choice.equals("checkout book") || choice.equals("Check-out Book")){

            String desiredBook = Helper.userSelection("Enter the title of the book you want to check-out. Please be aware of spelling.");
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
                System.out.println("Thank you! Enjoy the book");
                Book.instances.add(checkedBook);
            } else { System.out.println("Sorry, that book is not available.");}
        }
        else if (choice.equals("3") || (choice.equals("return a book"))){
            String toBeReturned = Helper.userSelection("Which book would you like to return?");
            ArrayList<Book> listBook = Book.getInstances();
            Book returningBook = null;
            for (Book book : listBook) {
                if (book.getName().equals(toBeReturned)) { returningBook = book;}
            }
            if (returningBook != null) {
                Book.instances.remove(returningBook);
                returningBook.returnBook();
                System.out.println("Thank you for returning the book");
                Book.instances.add(returningBook);
            } else { System.out.println("That is not a valid book to return.");}
        } else if (choice.equals("4") || choice.equals("list of movies") || choice.equals("List of Movies")) {

            ArrayList<Movie> listMovies = Movie.getInstances();
            for (Movie movie : listMovies) {
                if (!movie.checkoutStatus()) {
                    System.out.println(movie.toString());
                }
            }
        }else if (choice.equals("5") || choice.equals("checkout movie") || choice.equals("Check-out Movie")){

            String desiredMovie = Helper.userSelection("Enter the title of the movie you want to check-out. Please be aware of spelling.");
            ArrayList<Movie> listMovie = Movie.getInstances();
            Movie checkedMovie = null;
            for (Movie movie : listMovie) {
                if (movie.getName().equals(desiredMovie)) { checkedMovie = movie; }
            }
            if (checkedMovie != null) {
                Movie.instances.remove(checkedMovie);
                checkedMovie.checkOut();
                System.out.println("Thank you! Enjoy the movie");
                Movie.instances.add(checkedMovie);
            } else { System.out.println("Sorry, that movie is not available.");}
        }
        else System.out.println("Not a valid input.");
}
}
