package at.ac.fhcampuswien.fhmdb.fhmdb;

import static at.ac.fhcampuswien.fhmdb.fhmdb.Genre.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieTest {
    @Test
    void if_movieList_Genre_equals_correctList_Genre(){

        //Given
        //wanted Genre = ACTION
        Movie movie = new Movie("Matrix");
        List<Movie> movieList = new ArrayList<>();

        //When

        //Then

    }
    void upper_or_lower_case_should_be_ignored() {
        String expectedName = "matrix murder";
        String actualName = "MATRIX MURDER";
        assertEquals(expectedName, actualName.toLowerCase());
    }


    /*  try {
            List<Movie> movieList = new ArrayList<>();
            List<Movie> correctList = new ArrayList<>();
            for (int i = 0; i <= 9; i++) {
                Genre genre;
                if (i % 2 == 0) {
                    genre = ACTION;
                } else {
                    genre = HORROR;
                }
                Movie movie = new Movie(String.valueOf(i));
                movie.setDescription(String.valueOf(i));
                List<Genre> genreList = new ArrayList<>();
                genreList.add(genre);
                movie.setGenres(genreList);
                movieList.add(movie);
                if (i % 2 == 0) {
                    correctList.add(movie);
                }
            }
            assertEquals(correctList, Movie.filterAfterGenre(ACTION),movieList);
        }catch(Exception e){
            e.printStackTrace();
        }

       */
}
