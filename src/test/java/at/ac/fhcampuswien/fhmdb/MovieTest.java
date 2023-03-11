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
    void see_if_sport_movies_filtered_correctly(){

        //Given
        Genre wantedGenre = SPORT;
        Movie sportMovie = new Movie("Finishing the race");
        //sportMovie.setDescription(
        //        "The finish line in vision, only view last miles left. After running for so long the race between students and test are finally to an end. Now the have to face\n" + "their last ultimate enemy. They have to find out if they are up to this task after such long fighting or if they just got exhausted by now? If they are able to\n" + "overtake, what next? What is there after the finishing line, is it even worth it or will there be just another running track till infinity ...\n");
        //sportMovie.setGenres(Arrays.asList(FANTASY, SPORT, MYSTERY));
        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(sportMovie);
        //When
        Movie.initializeMovies();
        List<Movie> actualMovies = Movie.filterAfterGenre(wantedGenre);
        //Then
        assertEquals(expectedMovies.toString(), actualMovies.toString());

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