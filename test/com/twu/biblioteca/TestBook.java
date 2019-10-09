package com.twu.biblioteca;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class TestBook {

    Book book1 = Book.createBook("Hallo", "World", 1432);
    Book book2 = Book.createBook("Bookidi; McBookinsen of Bookholm (1826)");

    @Test
    public void testCreateBook() {


        assertThat(book1.getName(), is("Hallo"));
        assertThat(book1.getYear(), is(1432));
        assertThat(book2.getAuthor(), is("McBookinsen of Bookholm"));
        assertThat(book2.checkoutStatus(), is(false));
        assertThat(book2.getYear(), is(1826));
    }

    @Test
    public void testGetInstances() {
        assertThat(Book.getInstances(), instanceOf(ArrayList.class));
        assertThat(Book.getInstances().get(0).toString(), is(book1.toString()));
    }

    @Test
    public void testCheckOut() {
        book1.checkOut();

        assertThat(book1.checkoutStatus(), is(true));
        assertThat(book2.checkoutStatus(), is(false));
    }
}
