package com.example.gestorjuegos.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;
    @FXML
    private Label info;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;

    @FXML
    public void login(ActionEvent actionEvent) {
        //lee el usuario
        String user = txtUser.getText();
        String pass = txtPassword.getText();

        /*Acceso a base de datos para la validacion*/

        info.setText("Usuario: "+user+"("+pass+") correcto");
        info.setStyle("-fx-background-color: green;");

    }

    @FXML
    public void cancel(ActionEvent actionEvent) {
        //lo que hace es borrar los campos
        txtPassword.setText("");
        txtUser.setText("");
        info.setText("");
        info.setStyle("-fx-background-color: transparent");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}