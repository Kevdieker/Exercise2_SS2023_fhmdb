package at.ac.fhcampuswien.fhmdb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HomeController implements Initializable {

    @FXML
    private VBox home;
    @FXML
    private ComboBox<Genre> genreBox;
    @FXML
    private ComboBox<String> sortBox;
    @FXML
    private TextField searchField;
    private final List<Movie> allMovies = new ArrayList<>(Movie.initializeMovies());
    // if exercise 2 contains adding new movies by GUI this needs to be changed
    private List<Movie> selectedMovies = allMovies;
    private List<Movie> filteredMovies = allMovies;
    private List<Movie> searchedMovies = allMovies;
    private boolean searched = false;
    private boolean filtered = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genreBox.getItems().addAll(Genre.values());
        sortBox.getItems().addAll("A-Z", "Z-A");
        loadingMovies(allMovies);
    }

    public void OnActionFilterMovies() {

        selectedMovies = searchedMovies;
        filteredMovies = filterAfterGenre(genreBox.getValue(), selectedMovies);
        loadingMovies(filteredMovies);
        selectedMovies = filteredMovies;


    }

    public void OnActiveSearchMovies() {

            selectedMovies =filteredMovies;
            searchedMovies = searchAfterString(searchField.getText(), selectedMovies);
            loadingMovies(searchedMovies);
            selectedMovies = searchedMovies;

    }

    public void OnActiveSortMovies() {
        sortMovies(sortBox.getValue(), selectedMovies);
        loadingMovies(selectedMovies);
    }


    public void loadingMovies(List<Movie> movies) {
        home.getChildren().clear();
        try {
            for (Movie movie : movies) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("movie_card.fxml"));
                VBox movieSpace = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(movie);
                home.getChildren().add(movieSpace);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Movie> filterAfterGenre(Genre genre, List<Movie> movies) {
        if (genre == Genre.ALL) {
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

    public static String makeStringUniform(String polyformString) {
        return polyformString.toLowerCase().trim().replaceAll("\\s", "");
    }

    public List<Movie> searchAfterString(String searchedWord, List<Movie> movies) {
        searchedWord = makeStringUniform(searchedWord);
        List<Movie> searchedMovies = new ArrayList<>();
        if (!searchField.getText().isEmpty()) {
            for (Movie movie : movies) {
                if (makeStringUniform(movie.getTitle()).contains(searchedWord) ||
                        makeStringUniform(movie.getDescription()).contains(searchedWord) ||
                        makeStringUniform(movie.getGenresInStringFormat()).contains(searchedWord)) {
                    searchedMovies.add(movie);
                }
            }
            return searchedMovies;
        } else {
            return filteredMovies;
        }
    }

    public static List<Movie> sortMovies(String sortAlgo, List<Movie> movies) {
        if (sortAlgo.equals("A-Z")) {
            movies.sort(Comparator.comparing(Movie::getTitle));
        } else if (sortAlgo.equals("Z-A")) {
            movies.sort(Comparator.comparing(Movie::getTitle).reversed());
        }
        return movies;
    }

}