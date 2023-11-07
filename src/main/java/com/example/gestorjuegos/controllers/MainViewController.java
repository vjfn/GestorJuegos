package com.example.gestorjuegos.controllers;

import com.example.gestorjuegos.App;
import com.example.gestorjuegos.Session;
import com.example.gestorjuegos.domain.juego.Game;
import com.example.gestorjuegos.domain.juego.GameDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @javafx.fxml.FXML
    private Label info;
    @javafx.fxml.FXML
    private TableView<Game> tabla;
    @javafx.fxml.FXML
    private TableColumn<Game, String> cNombre;
    @javafx.fxml.FXML
    private TableColumn<Game, String> cPlataforma;
    @javafx.fxml.FXML
    private TableColumn<Game, String> cCategoria;
    @javafx.fxml.FXML
    private TableColumn<Game, String> cAño;
    @javafx.fxml.FXML
    private TableColumn<Game, String> cEstudio;
    @javafx.fxml.FXML
    private TableColumn<Game, String> cFormato;
    @javafx.fxml.FXML
    private Label lTotal;
    @javafx.fxml.FXML
    private MenuItem mSalir;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void salir(ActionEvent actionEvent) {
        Session.setCurentUser(null);
        try {
            App.changeScene("login-view.fxml","Login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cNombre.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getName())
        );

        cPlataforma.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getPlatform())
        );

        cAño.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getYear()+"")
        );

        cCategoria.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getCategory())
        );

        cEstudio.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getStudio())
        );

        cFormato.setCellValueFactory((fila)->
                new SimpleStringProperty(fila.getValue().getFormat())
        );

        lTotal.setText(Session.getCurentUser().getGamesQuantity()+" juegos");
        info.setText("Bienvenido "+Session.getCurentUser().getUsername());

        tabla.getItems().addAll(Session.getCurentUser().getGames());

        tabla.getSelectionModel().selectedItemProperty().addListener((observableValue, game, t1) -> {
            Session.setCurentGame(t1);
            try {
                App.changeScene("game-view.fxml", t1.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}