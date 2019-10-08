package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class TestBibFileReader {

    @Test
    public void TestReaderResultNotNull() throws Exception {
        BibFileReader reader = new BibFileReader();

        assertNotNull(reader.read());
    }

    @Test
    public void TestReaderReturnsList() throws Exception {
        BibFileReader reader = new BibFileReader();

        assertThat(reader.read(), instanceOf(ArrayList.class));
    }

    @Test
    public void TestYearIncluded() throws Exception {
        BibFileReader reader = new BibFileReader();
        ArrayList books = reader.read();
        String bookExample = books.get(1).toString();

        assertThat(bookExample, containsString("1"));

    }
}
