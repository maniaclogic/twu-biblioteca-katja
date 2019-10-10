package com.twu.biblioteca;

import java.io.*;

class Helper {

    static void readBooks(String path) throws Exception {

        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            Book.createBook(st);
    }

    static void readMovies(String path) throws Exception {

        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null)
            Movie.createMovie(st);
    }

    static String userSelection(String prompt) {
        String inputLine = " ";
        System.out.println(prompt + "   ");
        try {
            BufferedReader sysReader = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = sysReader.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}