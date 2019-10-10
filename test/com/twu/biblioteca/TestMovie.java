package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.hamcrest.core.IsInstanceOf.instanceOf;

public class TestMovie {

        Movie movie1 = Movie.createMovie("Hallo", 1432);
        Movie movie2 = Movie.createMovie("Movieidi McMovinsen of Movieken (1826)");

        @Test
        public void testCreateMovie() {


            assertThat(movie1.getName(), is("Hallo"));
            assertThat(movie1.getYear(), is(1432));
            assertThat(movie2.checkoutStatus(), is(false));
            assertThat(movie2.getYear(), is(1826));
        }

        @Test
        public void testGetInstances() {
            assertThat(Movie.getInstances(), instanceOf(ArrayList.class));
            assertThat(Movie.getInstances().get(0).toString(), is(movie1.toString()));
        }

//        @Test
//        public void testCheckOut() {
//            movie1.checkOut();
//
//            assertThat(movie1.checkoutStatus(), is(true));
//            assertThat(movie2.checkoutStatus(), is(false));
//        }

    }


