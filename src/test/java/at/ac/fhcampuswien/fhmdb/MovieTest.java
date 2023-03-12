package at.ac.fhcampuswien.fhmdb;

import static at.ac.fhcampuswien.fhmdb.Genre.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import java.util.List;

public class MovieTest {

    @Test
    void checks_if_movies_get_initialized(){
        //When
        List<Movie> movieList = Movie.initializeMovies();
        //Then
        assertFalse(movieList.isEmpty());
    }

}