package com.example.gestorjuegos.controllers;

import com.example.gestorjuegos.App;
import com.example.gestorjuegos.Session;
import com.example.gestorjuegos.domain.HibernateUtil;
import com.example.gestorjuegos.domain.usuario.User;
import com.example.gestorjuegos.domain.usuario.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
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

        if(user.length()<4 || pass.length()<4){
            info.setText("Introduce los datos");
            info.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        }else{
            /*Acceso a base de datos para la validacion*/

            User u = (new UserDAO()).validateUser(user,pass);

            if(u==null) {
                info.setText("No encontrado");
                info.setStyle("-fx-background-color: red; -fx-text-fill: white;");
            }else{
                info.setText("Usuario: "+user+"("+pass+") correcto");
                info.setStyle("-fx-background-color: green; -fx-text-fill: white;");

                Session.setCurentUser(u);
            /*guardar usuario en sesion e ir a la proxima ventana*/

                try {
                    App.changeScene("main-view.fxml","Login");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }




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
        //HibernateUtil.getSessionFactory();
    }
}