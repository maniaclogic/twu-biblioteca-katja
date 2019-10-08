package com.twu.biblioteca;

import org.junit.Test;
import java.lang.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestMockMenu {

    @Test
    public void testGreet () {
        Menu menu = new Menu();
        assertThat(menu.greet(), is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void testDisplay() {
        Menu menu = new Menu();
        assertThat(menu.display().toString(), is("\n\nOptions:\n 1) List of Books"));
    }

    @Test
    public void testNavExit() throws Exception {

        BibliotecaApp app = new BibliotecaApp();

        assertThat(app.exit, is(false));
        Menu.navigate("x");
        assertThat(app.exit, is(true));
    }
    /*@Test
    public void testUserSelection() throws IOException {

        when(readerMock.readLine()).thenReturn("1").thenReturn("LIST of BOOks");

        assertThat(readerMock.selection(), is("1"));
        assertThat(readerMock.selection(), is("list of books"));
    }*/
}
