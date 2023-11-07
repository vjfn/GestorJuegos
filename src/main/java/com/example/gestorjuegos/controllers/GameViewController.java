package com.example.gestorjuegos.controllers;


import com.example.gestorjuegos.App;
import com.example.gestorjuegos.Session;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {

    @javafx.fxml.FXML
    private MenuItem mCerrar;
    @javafx.fxml.FXML
    private MenuItem mVolver;
    @javafx.fxml.FXML
    private Label gameInfo;

    @javafx.fxml.FXML
    public void volver(ActionEvent actionEvent) {
        try {
            App.changeScene("main-view.fxml","Coleccion de videojuegos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {
        try {
            App.changeScene("login-view.fxml","Login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameInfo.setText(Session.getCurentGame().toString());
    }
}