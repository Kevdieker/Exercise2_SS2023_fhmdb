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
    private List<Movie> allMovies = new ArrayList<>(Movie.initializeMovies());
    private List<Movie> searchedMovies = allMovies;
    private List<Movie> filteredMovies = allMovies;
    private List<Movie> combinedSelectedMovies = allMovies;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genreBox.getItems().addAll(Genre.values());
        sortBox.getItems().addAll("A-Z", "Z-A");
        loadingMovies(allMovies);
    }
    // __________________ Node active actions _______________________//
    public void OnActionFilterMovies() {
        filteredMovies = filterAfterGenre(genreBox.getValue(), allMovies);
        combinedSelectedMovies = intersectingMovies(filteredMovies, searchedMovies);
        loadingMovies(combinedSelectedMovies);
    }
    public void OnActiveSearchMovies() {
        if (!searchField.getText().isEmpty()) {
            searchedMovies = searchAfterString(searchField.getText(), allMovies);
        }
        else{
            searchedMovies=filteredMovies;
        }
        combinedSelectedMovies = intersectingMovies(filteredMovies, searchedMovies);
        loadingMovies(combinedSelectedMovies);
    }
    public void OnActiveSortMovies() {
        allMovies=sortMovies(sortBox.getValue(), allMovies);
        combinedSelectedMovies=sortMovies(sortBox.getValue(), combinedSelectedMovies);
        loadingMovies(combinedSelectedMovies);
    }

    // ____________________________ METHODS ________________________________//
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
    public static List<Movie> searchAfterString(String searchedWord, List<Movie> movies) {
        searchedWord = makeStringUniform(searchedWord);
        List<Movie> searchedMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (makeStringUniform(movie.getTitle()).contains(searchedWord) ||
                    (movie.getDescription()!=null && makeStringUniform(movie.getDescription()).contains(searchedWord))){
                searchedMovies.add(movie);
            }
        }
        return searchedMovies;
    }
    public static List<Movie> sortMovies(String sortAlgo, List<Movie> movies) {
        if (sortAlgo.equals("A-Z")) {
            movies.sort(Comparator.comparing(Movie::getTitle));
        } else if (sortAlgo.equals("Z-A")) {
            movies.sort(Comparator.comparing(Movie::getTitle).reversed());
        }
        return movies;
    }
    public static List<Movie> intersectingMovies(List<Movie> list1, List<Movie> list2) {
        List<Movie> common = new ArrayList<>(list1);
        common.retainAll(list2);
        return common;
    }

    // ____________________________ LOADING SCREEN ________________________________//
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
