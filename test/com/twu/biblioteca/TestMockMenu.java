package com.twu.biblioteca;

import org.junit.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestMockMenu {


    @Test
    public void testDisplay() {
        Menu menu = new Menu();
        assertThat(menu.display().toString(), is("Options:\n\n 1) List of Books"));
    }

    /*@Test
    public void testUserSelection() throws IOException {

        when(readerMock.readLine()).thenReturn("1").thenReturn("LIST of BOOks");

        assertThat(readerMock.selection(), is("1"));
        assertThat(readerMock.selection(), is("list of books"));
    }*/
}
