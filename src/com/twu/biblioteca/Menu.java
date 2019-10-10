package com.twu.biblioteca;

import java.io.Console;
import java.util.ArrayList;

public class Menu {

    public String greet() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String display() {
        return "\n\nOptions:\n 1) List of Books \n 2) Check-out Book \n 3) Return a Book \n 4) List of Movies \n 5) Check-out Movie \n\n a) admin";
    }

    public static void navigate(String choice) throws Exception {
        char choi = choice.charAt(0);

        switch (choi) {
            case 'x':
                BibliotecaApp.exit = true;
                break;
            case '1':
                Menu.option1();
                break;
            case '2':
                Menu.option2();
                break;
            case '3':
                Menu.option3();
                break;
            case '4':
                Menu.option4();
                break;
            case '5':
                Menu.option5();
                break;
            case 'a':
                Menu.adminOption();
                break;
            default:
                System.out.println("Not a valid input.");
                break;
        }
    }

    private static void option1() {

        ArrayList<Book> listBook = Book.getInstances();
        for (Book book : listBook) {
            if (!book.checkoutStatus()) {
                System.out.println(book.toString());
            }
        }
    }

    private static void option2() {

        String desiredBook = Helper.userSelection("Enter the title of the book you want to check-out. Please be aware of spelling.");
        ArrayList<Book> listBook = Book.getInstances();
        Book checkedBook = null;

        for (Book book : listBook) {
            if (book.getName().equals(desiredBook)) {
                checkedBook = book;
            }
        }
        if (checkedBook != null) {

            String userId = Helper.userSelection("Id Number:   ");
            String password = Helper.userSelection("password:   ");
            boolean userFound = false;

            for (User user : User.getUserList()) {
                String dbuser = user.toString();
                String dbId = dbuser.split(";")[0];
                String dbpsswd = dbuser.split(";")[1];

                if (dbId.equals(userId) && dbpsswd.equals(password)) {

                    user.checkedOut(checkedBook);
                    userFound = true;

                }
            }

            if (userFound) {

                Book.instances.remove(checkedBook);
                checkedBook.checkOut();
                System.out.println("Thank you! Enjoy the book");
                Book.instances.add(checkedBook);

            } else {
                System.out.println("Incorrect credentials.");
            }

        } else {
            System.out.println("Sorry, that book is not available.");
        }
    }

    private static void option3() {

        String toBeReturned = Helper.userSelection("Which book would you like to return?");
        ArrayList<Book> listBook = Book.getInstances();
        Book returningBook = null;
        for (Book book : listBook) {
            if (book.getName().equals(toBeReturned)) {
                returningBook = book;
            }
        }
        if (returningBook != null) {
            Book.instances.remove(returningBook);
            returningBook.returnBook();
            System.out.println("Thank you for returning the book");
            Book.instances.add(returningBook);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    private static void option4() {

        ArrayList<Movie> listMovies = Movie.getInstances();
        for (Movie movie : listMovies) {
            if (!movie.checkoutStatus()) {
                System.out.println(movie.toString());
            }
        }
    }

    private static void option5() {

        String desiredMovie = Helper.userSelection("Enter the title of the movie you want to check-out. Please be aware of spelling.");
        ArrayList<Movie> listMovie = Movie.getInstances();
        Movie checkedMovie = null;

        for (Movie movie : listMovie) {

            if (movie.getName().equals(desiredMovie)) {
                checkedMovie = movie;
            }
        }

        if (checkedMovie != null) {

            String userId = Helper.userSelection("Id Number:   ");
            String password = Helper.userSelection("password:   ");
            boolean userFound = false;

            for (User user : User.getUserList()) {
                String dbuser = user.toString();
                String dbId = dbuser.split(";")[0];
                String dbpsswd = dbuser.split(";")[1];

                if (dbId.equals(userId) && dbpsswd.equals(password)) {

                    user.checkedOut(checkedMovie);
                    userFound = true;

                }
            }

            if (userFound) {

                Movie.instances.remove(checkedMovie);
                checkedMovie.checkOut();
                System.out.println("Thank you! Enjoy the movie");
                Movie.instances.add(checkedMovie);

            } else {
                System.out.println("Incorrect credentials.");
            }

        } else {
            System.out.println("Sorry, that movie is not available.");
        }
    }

    private static void adminOption() {

        String adminID = Helper.userSelection("ID: ");
        String adminPsswd = Helper.userSelection("Password: ");

        if (adminID.equals("Admin") && adminPsswd.equals("Secure")) {
            System.out.println("Options:\n 1) Search for User \n 2) Search for Media");
            String adminChoice = Helper.userSelection(" ");

            if (adminChoice.equals("1") || adminChoice.equals("search for user") || adminChoice.equals("user")) {
                String userSearch = Helper.userSelection("UserId:");
                for (User user : User.getUserList()) {
                    if (user.getIdNum().equals(userSearch)) {
                        System.out.println(user.getCheckedOutMedia());
                    }
                }

            } else if (adminChoice.equals("2") || adminChoice.equals("search for media") || adminChoice.equals("media")) {
                String mediaSearch = Helper.userSelection("Media title:");
                for (User user : User.getUserList()) {
                    if (user.getCheckedOutMedia().contains(mediaSearch)) {
                        System.out.println(user.toString() + user.getCheckedOutMedia());
                    }
                }
            } else { System.out.println("Not a valid input."); }

        } else { System.out.println("Invalid credentials"); }
    }

}
