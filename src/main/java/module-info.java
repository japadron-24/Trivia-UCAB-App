module edu.ucab.triviaucabapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ucab.triviaucabapp to javafx.fxml;
    exports edu.ucab.triviaucabapp;
}