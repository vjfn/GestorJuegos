module com.example.gestorjuegos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gestorjuegos to javafx.fxml;
    exports com.example.gestorjuegos;
    exports com.example.gestorjuegos.controllers;
    opens com.example.gestorjuegos.controllers to javafx.fxml;
}