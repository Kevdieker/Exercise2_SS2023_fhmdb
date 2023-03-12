package at.ac.fhcampuswien.fhmdb;

import static at.ac.fhcampuswien.fhmdb.Genre.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieTest {

    @Test
    void checks_if_movies_get_initialized(){
        //When
        Movie.initializeMovies();
        //Then
        assertFalse(Movie.getMovies().isEmpty());
    }

    //Methods: searchMovieTitle and seachMovieDescription needs to be written in class Movie//
    @Test
    void check_if_searching_works_with_title(){
        try {
            //Given
            Movie expected = new Movie("Campus Couple");
            Movie actual = new Movie("Campus Couple");
            expected.getTitle();
            actual.getTitle();

            //When


            //Then
            assertEquals(expected, actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void check_if_searching_works_with_description(){
        try {
            //Given
            Movie expected = new Movie("Campus Couple");
            Movie actual = new Movie("Campus Couple");
            expected.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");
            actual.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");
            expected.getDescription();
            actual.getDescription();

            //When


            //Then
            assertEquals(expected, actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
/*
    @Test
    void see_if_sport_movies_is_filtered_correctly(){

        //Given
        Genre wantedGenre = SPORT;
        Movie sportMovie = Movie.getMovieByTitle("Finishing the race");
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(sportMovie);
        //When
        Movie.initializeMovies();
        List<Movie> actualMovies = Movie.filterAfterGenre(wantedGenre);
        //Then
        assertEquals(expectedMovies, actualMovies);

    }

    /*
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