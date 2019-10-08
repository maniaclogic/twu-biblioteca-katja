package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {

    public String display() {
        return "Options:\n\n 1) List of Books";

    }

    public String userSelection(String prompt) {
        String inputLine = null;
        System.out.println(prompt + "   ");
        try {
            BufferedReader sysReader = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = sysReader.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public void navigate() throws Exception {
        String choice = this.userSelection("Input the number or name of what you want to do.");
        if (choice.equals("1") || choice.equals("list of books")) {
            BibFileReader reader = new BibFileReader();
            ArrayList listBooks = reader.read();
            for (Object book : listBooks) System.out.println(book);
        }
        else System.out.println("Not a valid input.");
}}
