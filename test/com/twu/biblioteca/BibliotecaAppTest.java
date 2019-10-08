package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.tools.doclint.Entity.not;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    @Test
    public void testCheckout() throws Exception {

        BibliotecaApp app = new BibliotecaApp();
        ArrayList<String> books = new ArrayList<String>() {{
            add("File");
            add("Edit");
            add("VieW");
            add("C8de");
            add("Analyze");
        }};

        assertThat(books.size(), is(not(app.checkout("Analyze", books).size())));
        assertThat(books.size(), is(app.checkout("Refactor", books).size()));


    }
}