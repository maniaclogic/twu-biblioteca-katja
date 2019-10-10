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
        assertThat(menu.display().toString(), is("\n\nOptions:\n 1) List of Books " +
                "\n 2) Check-out Book \n 3) Return a Book \n 4) List of Movies " +
                "\n 5) Check-out Movie \n\n a) admin"));
    }

    @Test
    public void testNavExit() throws Exception {

        BibliotecaApp app = new BibliotecaApp();

        assertThat(app.exit, is(false));
        Menu.navigate("x");
        assertThat(app.exit, is(true));
    }

    @Test
    public String testOption6() {
        User user1 = User.createUser("123-1234", "hsf3", "Tom", "0123-5225252", "abc@email.com");

        Menu mockMenu = mock(Menu.class);
        when(mockMenu.option6().thenReturn(user1.getUserContacts()));
        
        assertThat(Menu.option6())
    }

//    @Test
//    public void testOption2() {
//        Helper mockHelper = mock(Helper.class);
//        User user = User.createUser("123-4567", "fhsidhv");
//        when(mockHelper.userSelection("Book")).thenReturn("Moby-Dick")
//                .thenReturn("123-4567")
//                .thenReturn("fhsidhv");
//
//        verify(user).toString();}
}
