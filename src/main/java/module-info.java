module at.ac.fhcampuswien.fhmdb.fhmdb {
    requires javafx.controls;
    requires javafx.fxml;



    opens at.ac.fhcampuswien.fhmdb.fhmdb to javafx.fxml;
    exports at.ac.fhcampuswien.fhmdb.fhmdb;
}