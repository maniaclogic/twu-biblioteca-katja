package com.twu.biblioteca;

import java.util.ArrayList;

public class Movie implements Media {

    private String name;
    private int year;
    private boolean checkedOut = false;
    private double rating;
    private String director;
    public static ArrayList<Movie> instances = new ArrayList<Movie>();

    private Movie(String name, int year, double rating, String director) {
        this.name = name;
        this.year = year;
        this.rating= rating;
        this.director = director;

    }

    private Movie(String movieInfo) {
        String[] parts = movieInfo.split(" \\(");
        String[] figment = parts[1].split("\\) ");
        String[] piece = figment[1].split("; ");
        this.year = Integer.parseInt(figment[0]);
        this.name = parts[0];
        this.rating = Double.parseDouble(piece[0]);
        this.director = piece[1];
    }

    public static Movie createMovie(String name, int year, double rating, String director) {
        Movie movie = new Movie(name, year, rating, director);
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

    public double getRating() {
        return this.rating;
    }

    public String getDirector() {
        return this.director;
    }

    public static ArrayList<Movie> getInstances() {
        return instances;
    }

    public String toString() {
        return this.getName() +" ("+ this.getYear() +")     "+ this.getRating()+"    " + this.getDirector();
    }

    @Override
    public void checkOut() {
        this.checkedOut = true;
    }
}
