package at.ac.fhcampuswien.fhmdb;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static at.ac.fhcampuswien.fhmdb.Genre.*;
import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest{
    @Test
    void right_movies_are_filtered_after_ALL_genre(){
        //Given
        List<Movie> movieList = new ArrayList<>();
        List<Movie> expectedMovies = new ArrayList<>();

        Movie movie = new Movie("Sportmovie");
        expectedMovies.add(movie);
        movieList.add(movie);
        movie = new Movie("No_Sportmovie");
        expectedMovies.add(movie);
        movieList.add(movie);
        movie = new Movie("Sportmovie_And_Something_Different");
        expectedMovies.add(movie);
        movieList.add(movie);

        //When
        List<Movie> actualMovies = HomeController.filterAfterGenre(ALL, movieList);

        //Then
        assertEquals(expectedMovies, actualMovies);
    }
    @Test
    void movies_are_filtered_correctly_after_sport_genre(){
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
    @Test
    void String_is_getting_Uniformed(){
        //Given
        String polyformString = "   hIs name Was arnold_!";
        //When
        String actualString = HomeController.makeStringUniform(polyformString);
        //Then
        assertEquals("hisnamewasarnold_!", actualString);
    }

    @Test
    void right_movies_are_searched_after_Empty_Searchfield(){
        //Given

        String wantedString = "";
        List<Movie> movieList = new ArrayList<>();
        List<Movie> expectedMovies = new ArrayList<>();

        Movie movie = new Movie("Sportmovie");
        expectedMovies.add(movie);
        movieList.add(movie);

        movie = new Movie("No_Sportmovie");
        expectedMovies.add(movie);
        movieList.add(movie);

        movie = new Movie("Sportmovie_And_Something_Different");
        expectedMovies.add(movie);
        movieList.add(movie);

        //When
        List<Movie> actualMovies = HomeController.searchAfterString(wantedString,movieList);

        //Then
        assertEquals(expectedMovies, actualMovies);
    }
    @Test
    void movies_are_searched_correctly_after_String(){
        //Given
        String wantedString = "his";

        List<Movie> movieList = new ArrayList<>();
        List<Movie> expectedMovies = new ArrayList<>();

        Movie movie = new Movie("No_Sportmovie_his");
        movie.setDescription("______pow_FAMILY_____");
        movie.addGenre(ACTION);
        movieList.add(movie);
        expectedMovies.add(movie);

        movie = new Movie("healthy neighbours");
        movie.setDescription("______his_FAMILY_____");
        movie.addGenre(DRAMA);
        movieList.add(movie);
        expectedMovies.add(movie);

        movie = new Movie("Old Story's");
        movie.setDescription("______wow_FAMILY_____");
        movie.addGenre(HISTORY);
        movieList.add(movie);
        expectedMovies.add(movie);

        movie = new Movie("unhealthy neighbours");
        movie.setDescription("______not_FAMILY_____");
        movie.addGenre(HORROR);
        movieList.add(movie);


        //When
        List<Movie> actualMovies = HomeController.searchAfterString(wantedString, movieList);

        //Then
        assertEquals(expectedMovies, actualMovies);
    }



    // The rest of the code here
}



    /*
    void upper_or_lower_case_should_be_ignored() {
        String expectedName = "matrix murder";
        String actualName = "MATRIX MURDER";
        assertEquals(expectedName, actualName.toLowerCase());
    }

       */

