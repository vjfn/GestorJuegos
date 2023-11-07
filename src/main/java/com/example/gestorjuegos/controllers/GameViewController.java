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
    private Label labelTitle;
    @javafx.fxml.FXML
    private TextField txtName;
    @javafx.fxml.FXML
    private TextField txtCategory;
    @javafx.fxml.FXML
    private TextField txtFormat;
    @javafx.fxml.FXML
    private TextField txtEnterprise;
    @javafx.fxml.FXML
    private TextField txtStudio;
    @javafx.fxml.FXML
    private TextField txtGameStatus;
    @javafx.fxml.FXML
    private TextField txtBoxStatus;
    @javafx.fxml.FXML
    private Spinner spinnerYear;
    @javafx.fxml.FXML
    private Spinner spinnerPlayers;
    @javafx.fxml.FXML
    private ChoiceBox comboUser;
    @javafx.fxml.FXML
    private Button btnSave;
    @javafx.fxml.FXML
    private Button btnDelete;
    @javafx.fxml.FXML
    private Button btnReturn;

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

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void delete(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void returnBack(ActionEvent actionEvent) {
    }
}