package at.ac.fhcampuswien.fhmdb.fhmdb;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private VBox home;
    private List<Movie> movies;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movies = new ArrayList<>(Movie.initializeMovies());

        try {
            for (int i = 0; i < movies.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("movie_card.fxml"));
                VBox movieSpace = fxmlLoader.load();
                MovieController movieController = fxmlLoader.getController();
                movieController.setData(movies.get(i));
                home.getChildren().add(movieSpace);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}










