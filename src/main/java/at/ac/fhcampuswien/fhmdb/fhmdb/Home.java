package at.ac.fhcampuswien.fhmdb.fhmdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Home extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        stage.setTitle("MovieCampus");

        //stage.getIcons().add(new Image("C:\\Users\\kevin\\Projekte\\IdeaProjects\\javaProjects\\javaFX_Projects\\Exercise1_SS2023_fhmdb\\src\\main\\resources\\at\\ac\\fhcampuswien\\fhmdb\\fhmdb\\images\\movie_campus.png"));

        stage.setScene(new Scene(root,1215,790));
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}