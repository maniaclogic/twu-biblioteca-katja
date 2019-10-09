package com.twu.biblioteca;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Helper {

    static void readFile() throws Exception {

        File file = new File("/Users/katben/Documents/TWU_Biblioteca-master/src/com/twu/biblioteca/bookList.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<String> books = new ArrayList<String>();
        while ((st = br.readLine()) != null)
            Book.createBook(st);
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