package com.twu.biblioteca;

import java.util.ArrayList;

public class Movie implements Media {

    private String name;
    private int year;
    private boolean checkedOut = false;
    public static ArrayList<Movie> instances = new ArrayList<Movie>();

    private Movie(String name, int year) {
        this.name = name;
        this.year = year;
    }

    private Movie(String movieInfo) {
        String[] parts = movieInfo.split(" \\(");
        String[] figment = parts[1].split("\\)");
        this.year = Integer.parseInt(figment[0]);
        this.name = parts[0];
    }

    public static Movie createMovie(String name, int year) {
        Movie movie = new Movie(name, year);
        instances.add(movie);
        return movie;
    }

    public static Movie createMovie(String movieInfo) {
        Movie movie = new Movie(movieInfo);
        instances.add(movie);
        return movie;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    public boolean checkoutStatus() {
        return this.checkedOut;
    }

    public static ArrayList<Movie> getInstances() {
        return instances;
    }

    public String toString() {

        return this.getName() +" ("+ this.getYear() +")";
    }

    @Override
    public void checkOut(){

    }
}
