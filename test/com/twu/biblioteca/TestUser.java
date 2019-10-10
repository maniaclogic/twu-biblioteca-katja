package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class TestUser {

    User user1 = User.createUser("123-1234", "hsf3", "Tom", "0123-5225252", "abc@email.com");
    Book book3 = Book.createBook("Super", "Cool", 100);


    @Test
    public void testGetters() {
        assertThat(user1.getIdNum(), is("123-1234"));
        assertThat(user1.getPsswd(), is("hsf3"));
        assertThat(user1.getName(), is("Tom"));
        assertThat(user1.getNumber(), is("0123-5225252"));
        assertThat(user1.getEmail(), is("abc@email.com"));
    }

    @Test
    public void testCheckedOut() {
        ArrayList<String> array = new ArrayList<String>();
        array.add(book3.toString());

        user1.checkedOut(book3);
        assertThat(user1.getCheckedOutMedia(), is(array));
    }

    @Test
    public void testGetUserContacts() {
        assertThat(user1.getUserContacts(), is("ID: 123-1234, Name: Tom, Tel: 0123-5225252, Email: abc@email.com"));
    }

}
