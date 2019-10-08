package com.twu.biblioteca;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class BibFileReader {

    public ArrayList read() throws Exception {

        File file = new File("/Users/katben/Documents/TWU_Biblioteca-master/src/com/twu/biblioteca/bookList.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<String> books = new ArrayList<String>();
        while ((st = br.readLine()) != null)
            books.add(st);

        return (ArrayList) books;
    }
}