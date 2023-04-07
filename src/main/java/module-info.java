module at.ac.fhcampuswien.fhmdb.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;


    opens at.ac.fhcampuswien.fhmdb to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb;
}