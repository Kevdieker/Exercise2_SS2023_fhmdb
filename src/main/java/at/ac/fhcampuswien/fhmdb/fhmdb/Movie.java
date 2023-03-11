package at.ac.fhcampuswien.fhmdb.fhmdb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static at.ac.fhcampuswien.fhmdb.fhmdb.Genre.*;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres;
    private static List<Movie> movies = new ArrayList<>();


    public Movie(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getGenresInStringFormat() {
        return genres.toString();
    }

    public static List<Movie> initializeMovies() {
        //List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie("Campus Couples Love Story");
        movie.setDescription(
                "2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not \n" +"only there are struggles in their new found love, but also they have to face the challenges of studying ...\n");
        movie.setGenres(Arrays.asList(ROMANCE, WAR, DRAMA, COMEDY));
        movies.add(movie);

        movie = new Movie("Matrix Murder");
        movie.setDescription(
                "In Math class, there is a topic, everyone fears! Only the bravest students will survive. They already fought 2 whole battles. Our fighters heavily injured.\n" +"Watch the last ultimate battle of the last possible examination. Will they fail or will they survive?\n");
        movie.setGenres(Arrays.asList(HORROR, CRIME, ACTION, THRILLER, MYSTERY, DRAMA));
        movies.add(movie);

        movie = new Movie("Oh Campina Campina!");
        movie.setDescription(
                "Our daily meal as students of FHCW, a mystery. We are visiting the kitchen of Campina for one day. Come and see how we discover and expose all secrets.\n" +"Recipes included!\n");
        movie.setGenres(Arrays.asList(MYSTERY, HISTORY, HORROR, DOCUMENTARY));
        movies.add(movie);

        movie = new Movie("Dream Team");
        movie.setDescription(
                "Teamwork can be exhausting, traumatizing and depressing. However, all above it is the most beautiful thing in the world!\n");
        movie.setGenres(Arrays.asList(MUSICAL, FAMILY, ADVENTURE));
        movies.add(movie);

        return movies;
    }

    public static List<Movie> filterAfterGenre(Genre genre){
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie:movies){
            if (movie.getGenres().contains(genre)){
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }
}
