package com.twu.biblioteca;

import org.junit.Test;
import java.lang.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;




public class TestMockMenu {

    @Test
    public void testGreet () {
        Menu menu = new Menu();
        assertThat(menu.greet(), is("Welcome to Biblioteca. " +
                "Your one-stop-shop for great book titles in Bangalore!"));
    }

    @Test
    public void testDisplay() {
        Menu menu = new Menu();
        assertThat(menu.display().toString(), is("\n\nOptions:\n1) Login \n 2) Logout \n 3) List of Books \n 4) Check-out Book \n " +
                "5) Return a Book \n 6) List of Movies \n " +
                "7) Check-out Movie \n 8) See my contact details \n\n a) admin"));
    }

    @Test
    public void testNavExit() throws Exception {

        Menu menu = new Menu();

        BibliotecaApp app = new BibliotecaApp();

        assertThat(app.exit, is(false));
        menu.navigate("x");
        assertThat(app.exit, is(true));
    }

//    @Test
//    public String testOption6() {
//        User user1 = User.createUser("123-1234", "hsf3", "Tom", "0123-5225252", "abc@email.com");
//
//        Menu mockMenu = mock(Menu.class);
//        when(mockMenu.option6().thenReturn(user1.getUserContacts()));
//
//        assertThat(Menu.option6(), is("ID: 123-1234, Name: Tom, Tel: 0123-5225252, Email: abc@email.com"));
//    }

//    @Test
//    public void testCheckOutBook() {
//        Helper mockHelper = mock(Helper.class);
//
//
//        User user1 = User.createUser("123-1234", "hsf3", "Tom", "0123-5225252", "abc@email.com");
//        when(mockHelper.userSelection("Book")).thenReturn("Moby-Dick");
//
//        verify(user).toString();}
}
