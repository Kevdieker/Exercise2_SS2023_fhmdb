package test;

import at.ac.fhcampuswien.fhmdb.fhmdb.Genre;
import at.ac.fhcampuswien.fhmdb.fhmdb.Movie;
import at.ac.fhcampuswien.fhmdb.fhmdb.MovieController;
import org.junit.jupiter.api.Test;

import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static at.ac.fhcampuswien.fhmdb.fhmdb.Genre.*;
import static at.ac.fhcampuswien.fhmdb.fhmdb.Genre.DRAMA;
import static org.junit.jupiter.api.Assertions.*;
class MovieTest {

    @Test
    void if_Action_show_Matrix_Murder(){
        Movie movie = new Movie("Matrix Murder");
        MovieController movieController = new MovieController();
        movie.setGenres(Arrays.asList(ACTION, DRAMA));
    }

}