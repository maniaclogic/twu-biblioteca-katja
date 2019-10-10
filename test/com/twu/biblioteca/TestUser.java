package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TestUser {

    User user1 = User.createUser("123-1234", "hsf3");
    Book book3 = Book.createBook("Super", "Cool", 100);


    @Test
    public void testGetters() {
        assertThat(user1.getIdNum(), is("123-1234"));
        assertThat(user1.getPsswd(), is("hsf3"));
    }

    @Test
    public void testCheckedOut() {
        ArrayList<String> array = new ArrayList<String>();
        array.add(book3.toString());

        user1.checkedOut(book3);
        assertThat(user1.getCheckedOutMedia(), is(array));
    }

}
