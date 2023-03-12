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

    @Test
    void check_if_searching_works_with_title_undercase(){
        try {
            //Given
            Movie given = new Movie("Campus Couple");
            Movie expected = new Movie("Campus Couple");

            //When
            Movie actual = (Movie) given.searchingMovies("campus couple");

            //Then
            assertEquals(expected.getTitle(), actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void check_if_searching_works_with_title_uppercase(){
        try {
            //Given
            Movie given = new Movie("Campus Couple");
            Movie expected = new Movie("Campus Couple");

            //When
            Movie actual = (Movie) given.searchingMovies("CAMPUS COUPLE");

            //Then
            assertEquals(expected.getTitle(), actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void check_if_searching_works_with_title_uppercase_mixed_with_undercase(){
        try {
            //Given
            Movie given = new Movie("Campus Couple");
            Movie expected = new Movie("Campus Couple");

            //When
            Movie actual = (Movie) given.searchingMovies("CaMPuS CouPLe");

            //Then
            assertEquals(expected.getTitle(), actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void if_searching_works_with_title_written_wrong(){
        try {
            //Given
            Movie actual = new Movie("Campus Couple");

            //When
            actual.searchingMovies("zwischen");

            //Then
            assertEquals("This movie cannot be found", actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void check_if_searching_works_with_description_uppercase(){
        try {
            //Given
            Movie given = new Movie("Campus Couple");
            given.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");
            Movie expected = new Movie("Campus Couple");
            expected.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");

            //When
            Movie actual = (Movie) given.searchingMovies("BETWEEN");

            //Then
            assertEquals(expected.getDescription(), actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void check_if_searching_works_with_description_undercase(){
        try {
            //Given
            Movie given = new Movie("Campus Couple");
            given.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");
            Movie expected = new Movie("Campus Couple");
            expected.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");

            //When
            Movie actual = (Movie) given.searchingMovies("between");

            //Then
            assertEquals(expected.getDescription(), actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void check_if_searching_works_with_description_undercase_mixed_uppercase(){
        try {
            //Given
            Movie given = new Movie("Campus Couple");
            given.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");
            Movie expected = new Movie("Campus Couple");
            expected.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");

            //When
            Movie actual = (Movie) given.searchingMovies("BeTwEeN");

            //Then
            assertEquals(expected.getDescription(), actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void if_searching_works_with_description_written_wrong(){
        try {
            //Given
            Movie actual = new Movie("Campus Couple");
            actual.setDescription("2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not only there are struggles in their new found love, but also they have to face the challenges of studying ...");
            actual.getDescription();

            //When
            actual.searchingMovies("zwischen");

            //Then
            assertEquals("This movie cannot be found", actual);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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