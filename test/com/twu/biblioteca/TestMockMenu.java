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
        assertThat(menu.display().toString(), is("\n\nOptions:\n 1) List of Books \n 2) Check-out Book \n 3) Return a Book \n 4) List of Movies \n 5) Check-out Movie \n\n a) admin"));
    }

    @Test
    public void testNavExit() throws Exception {

        BibliotecaApp app = new BibliotecaApp();

        assertThat(app.exit, is(false));
        Menu.navigate("x");
        assertThat(app.exit, is(true));
    }
}
