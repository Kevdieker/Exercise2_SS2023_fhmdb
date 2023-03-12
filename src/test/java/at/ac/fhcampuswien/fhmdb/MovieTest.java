package at.ac.fhcampuswien.fhmdb;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class MovieTest {
    @Test
    void initialized_movielist_contains_anything(){
        //When
        List<Movie> movieList = Movie.initializeMovies();
        //Then
        assertFalse(movieList.isEmpty());
    }
    /*
    @Test
    void initialized_movielist_contains_a_specific_movie(){
        //Given
        String movie = "he";
        //When
        List<Movie> movieList = Movie.initializeMovies();
        String movies =movieList.toString();
        //Then
        assertTrue(movies.contains(movie));
    }
    */
}