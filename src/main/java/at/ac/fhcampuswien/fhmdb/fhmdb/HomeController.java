package at.ac.fhcampuswien.fhmdb.fhmdb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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

    private List<Movie> movies;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genreBox.getItems().addAll(Genre.values());
        sortBox.getItems().addAll("A-Z", "Z-A");
        movies = new ArrayList<>(Movie.initializeMovies());
        loadingMovies(movies);
    }

    public void OnActionFilterMovies() {
        movies = Movie.filterAfterGenre(genreBox.getValue(),movies);
        loadingMovies(movies);
    }

    public void OnActiveSortMovies() {
        if (sortBox.getValue().equals("A-Z")) {
            movies.sort(Comparator.comparing(Movie::getTitle));
        } else if (sortBox.getValue().equals("Z-A")) {
            movies.sort(Comparator.comparing(Movie::getTitle).reversed());
        }
        loadingMovies(movies);
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
}











