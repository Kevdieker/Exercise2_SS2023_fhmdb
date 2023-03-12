package at.ac.fhcampuswien.fhmdb.fhmdb;

import at.ac.fhcampuswien.fhmdb.Genre;
import at.ac.fhcampuswien.fhmdb.HomeController;
import at.ac.fhcampuswien.fhmdb.Movie;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static at.ac.fhcampuswien.fhmdb.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest{

    @Test
    void see_if_movies_are_filtered_correctly_after_sport_genre(){
        //Given
        Genre wantedGenre = SPORT;
        List<Movie> movieList = new ArrayList<>();
        List<Movie> expectedMovies = new ArrayList<>();
        Movie movie = new Movie("Sportmovie");
        movie.addGenre(wantedGenre);
        movieList.add(movie);
        expectedMovies.add(movie);
        movie = new Movie("No_Sportmovie");
        movie.addGenre(ACTION);
        movieList.add(movie);
        movie = new Movie("Sportmovie_And_Something_Different");
        movie.addGenre(FAMILY);
        movie.addGenre(wantedGenre);
        movieList.add(movie);
        expectedMovies.add(movie);
        //When
        List<Movie> actualMovies = HomeController.filterAfterGenre(wantedGenre, movieList);
        //Then
        assertEquals(expectedMovies, actualMovies);
    }

    /*
    void upper_or_lower_case_should_be_ignored() {
        String expectedName = "matrix murder";
        String actualName = "MATRIX MURDER";
        assertEquals(expectedName, actualName.toLowerCase());
    }

       */

}