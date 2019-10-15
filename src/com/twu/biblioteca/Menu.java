package com.twu.biblioteca;

import java.util.ArrayList;

class Menu {

    private String userId;
    private String userPsswd;

    String greet() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    String display() {
        return "\n\nOptions:\n 1) Login \n 2) Logout \n 3) List of Books \n 4) Check-out Book \n 5) Return a Book \n 6) List of Movies \n " +
                "7) Check-out Movie \n 8) See my contact details \n\n a) admin";
    }

    void navigate(String choice) throws Exception {

        char choi = choice.charAt(0);

        switch (choi) {
            case 'x':
                BibliotecaApp.exit = true;
                break;
            case '1':
                this.login();
                break;
            case '2':
                this.logout();
                break;
            case '3':
                this.displayBooks();
                break;
            case '4':
                this.checkBookOut();
                break;
            case '5':
                this.returnBook();
                break;
            case '6':
                this.displayMovies();
                break;
            case '7':
                this.checkMovieOut();
                break;
            case '8':
                this.contactDetails();
                break;
            case 'a':
                this.adminOption();
                break;
            default:
                System.out.println("Not a valid input.");
                break;
        }
    }

    private void login() {
        this.userId = Helper.userSelection("ID: ");
        this.userPsswd = Helper.userSelection("Password: ");
    }

    private void logout() {
        this.userId = "";
        this.userPsswd = "";
    }

    private void displayBooks() {

        ArrayList<Book> listBook = Book.getInstances();
        for (Book book : listBook) {
            if (!book.checkoutStatus()) {
                System.out.println(book.toString());
            }
        }
    }

    private void checkBookOut() {

        String desiredBook = Helper.userSelection("Enter the title of the book you want to check-out. Please be aware of spelling.");

        ArrayList<Book> listBook = Book.getInstances();
        Book checkedBook = null;

        for (Book book : listBook) {
            if (book.getName().equals(desiredBook)) {
                checkedBook = book;
            }
        }
        if (checkedBook != null) {

            User user = User.authenticate(this.userId, this.userPsswd);
            if (user != null) {

                user.checkedOut(checkedBook);
                Book.instances.remove(checkedBook);
                checkedBook.checkOut();
                System.out.println("Thank you! Enjoy the book");
                Book.instances.add(checkedBook);

            } else {
                System.out.println("Invalid credentials.");
            }

        } else {
            System.out.println("Sorry, that book is not available.");
        }
    }

    private void returnBook() {

        String toBeReturned = Helper.userSelection("Which book would you like to return?");
        ArrayList<Book> listBook = Book.getInstances();
        Book returningBook = null;
        for (Book book : listBook) {
            if (book.getName().equals(toBeReturned)) {
                returningBook = book;
            }
        }
        if (returningBook != null) {
            User userFound = User.authenticate(this.userId, this.userPsswd);

            if (userFound != null) {

                userFound.returned(returningBook);
                Book.instances.remove(returningBook);
                returningBook.returnBook();
                System.out.println("Thank you for returning the book");
                Book.instances.add(returningBook);
            }
        } else { System.out.println("That is not a valid book to return."); }
    }

    private void displayMovies() {

        ArrayList<Movie> listMovies = Movie.getInstances();
        for (Movie movie : listMovies) {
            if (!movie.checkoutStatus()) {
                System.out.println(movie.toString());
            }
        }
    }

    private void checkMovieOut() {

        String desiredMovie = Helper.userSelection("Enter the title of the movie you want to check-out. Please be aware of spelling.");
        ArrayList<Movie> listMovie = Movie.getInstances();
        Movie checkedMovie = null;

        for (Movie movie : listMovie) {

            if (movie.getName().equals(desiredMovie)) {
                checkedMovie = movie;
            }
        }

        if (checkedMovie != null) {

            User user = User.authenticate(this.userId, this.userPsswd);

            if (user != null) {

                user.checkedOut(checkedMovie);
                Movie.instances.remove(checkedMovie);
                checkedMovie.checkOut();
                System.out.println("Thank you! Enjoy the movie");
                Movie.instances.add(checkedMovie);

            } else {
                System.out.println("Invalid credentials.");
            }

        } else {
            System.out.println("Sorry, that movie is not available.");
        }
    }

    private void contactDetails() {

        User user = User.authenticate(this.userId, this.userPsswd);

        if (user != null) { System.out.println(user.getUserContacts()); }
    }

    private void adminOption() {

        if (this.userId.equals("Admin") && this.userPsswd.equals("Secure")) {

            System.out.println("Options:\n 1) Search for User \n 2) Search for Media");
            String adminChoice = Helper.userSelection(" ");
            assert adminChoice != null;

            if (adminChoice.equals("1") || adminChoice.equals("search for user") || adminChoice.equals("user")) {

                this.adminUserSearch(Helper.userSelection("UserID: "));

            } else if (adminChoice.equals("2") || adminChoice.equals("search for media") || adminChoice.equals("media")) {

                this.adminMediaSearch(Helper.userSelection("Media title:"));

            } else {
                System.out.println("Not a valid input.");
            }

        } else { System.out.println("User is not an Admin"); }
    }


    private void adminUserSearch(String userToSearch) {
        boolean userFound = false;
        for (User user : User.getUserList()) {
            if (user.getIdNum().equals(userToSearch)) {
                System.out.println(user.getCheckedOutMedia());
                userFound = true;
            }
        }
        if (!userFound) {
            System.out.println("User couldn't be found.");
        }
    }

    private void adminMediaSearch(String mediaToSearch) {
        boolean mediaFound = false;
        for (User user : User.getUserList()) {
            ArrayList<String> usersMedia = user.getCheckedOutMedia();
            for (String media : usersMedia) {
                assert mediaToSearch != null;
                if (media.contains(mediaToSearch)) {
                    System.out.println(user.getUserContacts() + "\nCurrent Media: " + user.getCheckedOutMedia());
                    mediaFound = true;
                }
            }
        }
        if (!mediaFound) {
            System.out.println("Media couldn't be found");
        }
    }
}