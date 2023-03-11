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

        Movie movie = new Movie("Campus Couple Love Story");
        movie.setDescription(
                "2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not \n" + "only there are struggles in their new found love, but also they have to face the challenges of studying ...\n");
        movie.setGenres(Arrays.asList(ROMANCE, WAR, DRAMA, COMEDY));
        movies.add(movie);

        movie = new Movie("Matrix Murder");
        movie.setDescription(
                "In Math class, there is a topic, everyone fears! Only the bravest students will survive. They already fought 2 whole battles. Our fighters heavily injured.\n" + "Watch the last ultimate battle of the last possible examination. Will they fail or will they survive?\n");
        movie.setGenres(Arrays.asList(HORROR, CRIME, ACTION, THRILLER, MYSTERY, DRAMA));
        movies.add(movie);

        movie = new Movie("Operating Systems o´clock");
        movie.setDescription(
                "It is time for operating systems. Get the laptops out, start the console line and let´s go. Every command will effect something different, every combination\n" +"an individual masterpiece. It is up to the programmer, what he wants to do next. Will all the missing parts be found to succeed? Will all riddles get solved?\n" + "This is an up close movie to the fight of getting all points in the operating system test on Oracle.\n");
        movie.setGenres(Arrays.asList(ACTION, ANIMATION, SCIENCE_FICTION));
        movies.add(movie);

        movie = new Movie("Operating Systems o´clock 2");
        movie.setDescription(
                "They failed. But only so closely. But nevertheless they failed. What do to now? Preparing better, getting better, being better! But will it be enough in the\n" +"end? Or will they have to submit themselves to the powers of the complexity of the operating systems ...\n");
        movie.setGenres(Arrays.asList(DRAMA, ACTION, ANIMATION, SCIENCE_FICTION));
        movies.add(movie);

        movie = new Movie("Oh Campina Campina!");
        movie.setDescription(
                "Our daily meal as students of FHCW, a mystery. We are visiting the kitchen of Campina for one day. Come and see how we discover and expose all secrets.\n" + "Recipes included!\n");
        movie.setGenres(Arrays.asList(MYSTERY, HISTORY, HORROR, DOCUMENTARY));
        movies.add(movie);

        movie = new Movie("Dream Team");
        movie.setDescription(
                "Teamwork can be exhausting, traumatizing and depressing. However, all above it is the most beautiful thing in the world!\n");
        movie.setGenres(Arrays.asList(MUSICAL, FAMILY, ADVENTURE));
        movies.add(movie);

        movie = new Movie("Rubber ducks invasion");
        movie.setDescription(
                "The first rubber duck was found nowhere less special than in David Brek's backpack on his way to a heist. He, most feared leader, and his accomplices\n" + "were the most-wanted criminals in whole Western City. Since that moment, even more and more ducks appeared in their backpacks. No matter how\n" + "much they observed their backpacks, the duck drama didn´t end. If they don´t stop the duck avalanche in time they will be found. The time is ticking.\n");
        movie.setGenres(Arrays.asList(MYSTERY, WESTERN, FAMILY, COMEDY, ADVENTURE));
        movies.add(movie);

        movie = new Movie("Finishing the race");
        movie.setDescription(
                "The finish line in vision, only view last miles left. After running for so long the race between students and test are finally to an end. Now the have to face\n" + "their last ultimate enemy. They have to find out if they are up to this task after such long fighting or if they just got exhausted by now? If they are able to\n" + "overtake, what next? What is there after the finishing line, is it even worth it or will there be just another running track till infinity ...\n");
        movie.setGenres(Arrays.asList(FANTASY, SPORT, MYSTERY));
        movies.add(movie);

        return movies;
    }

    public static List<Movie> filterAfterGenre(Genre genre, List<Movie> movies) {
        if (genre == ALL) {
            return movies;
        } else {
            List<Movie> filteredMovies = new ArrayList<>();
            for (Movie movie : movies) {
                if (movie.getGenres().contains(genre)) {
                    filteredMovies.add(movie);
                }
            }
            return filteredMovies;
        }
    }
}

