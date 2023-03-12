package at.ac.fhcampuswien.fhmdb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres = new ArrayList<>();


    public Movie(String title) {
        this.title = title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void addGenre(Genre genre) { this.genres.add(genre); }
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
        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie("Campus Couple Love Story");
        movie.setDescription(
                "2 students, 1 love. Between lectures, exercises and test there is something exciting and new. Our two main character experience the beauty of love. But not \n" + "only there are struggles in their new found love, but also they have to face the challenges of studying ...\n");
        movie.setGenres(Arrays.asList(Genre.ROMANCE, Genre.WAR, Genre.DRAMA, Genre.COMEDY));
        movies.add(movie);

        movie = new Movie("Matrix Murder");
        movie.setDescription(
                "In Math class, there is a topic, everyone fears! Only the bravest students will survive. They already fought 2 whole battles. Our fighters heavily injured.\n" + "Watch the last ultimate battle of the last possible examination. Will they fail or will they survive?\n");
        movie.setGenres(Arrays.asList(Genre.HORROR, Genre.CRIME, Genre.ACTION, Genre.THRILLER, Genre.MYSTERY, Genre.DRAMA));
        movies.add(movie);

        movie = new Movie("Operating Systems o´clock");
        movie.setDescription(
                "It is time for operating systems. Get the laptops out, start the console line and let´s go. Every command will effect something different, every combination\n" +"an individual masterpiece. It is up to the programmer, what he wants to do next. Will all the missing parts be found to succeed? Will all riddles get solved?\n" + "This is an up close movie to the fight of getting all points in the operating system test on Oracle.\n");
        movie.setGenres(Arrays.asList(Genre.ACTION, Genre.ANIMATION, Genre.SCIENCE_FICTION));
        movies.add(movie);

        movie = new Movie("Operating Systems o´clock 2");
        movie.setDescription(
                "They failed. But only so closely. But nevertheless they failed. What do to now? Preparing better, getting better, being better! But will it be enough in the\n" +"end? Or will they have to submit themselves to the powers of the complexity of the operating systems ...\n");
        movie.setGenres(Arrays.asList(Genre.DRAMA, Genre.ACTION, Genre.ANIMATION, Genre.SCIENCE_FICTION));
        movies.add(movie);

        movie = new Movie("Howdy Campus");
        movie.setDescription(
                "Explore the Wild West in 'Howdy Campus: Uncovering the Origins of the FH'.\nWitness the struggles of a small group of pioneers wanting to bring education in a land without laws and rules.\nWill they be successful? This captivating documentary is a must-see for anyone who loves history, the Wild West, and the power of knowledge.\n");
        movie.setGenres(Arrays.asList(Genre.DOCUMENTARY, Genre.WESTERN, Genre.HISTORY));

        movie = new Movie("Oh Campina Campina!");
        movie.setDescription(
                "Our daily meal as students of FHCW, a mystery. We are visiting the kitchen of Campina for one day. Come and see how we discover and expose all secrets.\n" + "Recipes included!\n");
        movie.setGenres(Arrays.asList(Genre.MYSTERY, Genre.HISTORY, Genre.HORROR, Genre.DOCUMENTARY));
        movies.add(movie);

        movie = new Movie("Dream Team");
        movie.setDescription(
                "Teamwork can be exhausting, traumatizing and depressing. However, all above it is the most beautiful thing in the world!\n");
        movie.setGenres(Arrays.asList(Genre.MUSICAL, Genre.FAMILY, Genre.ADVENTURE));
        movies.add(movie);

        movie = new Movie("Rubber duck invasion");
        movie.setDescription(
                "The first rubber duck was found nowhere less special than in David Brek's backpack on his way to a heist. He, most feared leader, and his accomplices\n" + "were the most-wanted criminals in whole Western City. Since that moment, even more and more ducks appeared in their backpacks. No matter how\n" + "much they observed their backpacks, the duck drama didn´t end. If they don´t stop the duck avalanche in time they will be found. The time is ticking.\n");
        movie.setGenres(Arrays.asList(Genre.MYSTERY, Genre.WESTERN, Genre.FAMILY, Genre.COMEDY, Genre.ADVENTURE));
        movies.add(movie);

        movie = new Movie("Howdy Campus");
        movie.setDescription(
                "Explore the Wild West in 'Howdy Campus: Uncovering the Origins of the FH'.\nWitness the struggles of a small group of pioneers wanting to bring education in a land without laws and rules.\nWill they be successful? This captivating documentary is a must-see for anyone who loves history, the Wild West, and the power of knowledge.\"");
        movie.setGenres(Arrays.asList(Genre.DOCUMENTARY, Genre.WESTERN, Genre.HISTORY));

        movie = new Movie("Finishing the race");
        movie.setDescription(
                "The finish line in vision, only view last miles left. After running for so long the race between students and test are finally to an end. Now the have to face\n" + "their last ultimate enemy. They have to find out if they are up to this task after such long fighting or if they just got exhausted by now? If they are able to\n" + "overtake, what next? What is there after the finishing line, is it even worth it or will there be just another running track till infinity ...\n");
        movie.setGenres(Arrays.asList(Genre.FANTASY, Genre.SPORT, Genre.MYSTERY));
        movies.add(movie);


        return movies;
    }

}