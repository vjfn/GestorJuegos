package com.example.gestorjuegos.controllers;


import com.example.gestorjuegos.App;
import com.example.gestorjuegos.Session;
import com.example.gestorjuegos.domain.HibernateUtil;
import com.example.gestorjuegos.domain.juego.Game;
import com.example.gestorjuegos.domain.usuario.User;
import com.example.gestorjuegos.domain.usuario.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import org.hibernate.Transaction;

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
    private TextField txtPlatform;

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
        spinnerPlayers.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,4,1,1));
        spinnerYear.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1970,2023,1990,1));
        comboUser.setConverter(new StringConverter<User>() {
            @Override
            public String toString(User user) {
                return (user!=null)? user.getUsername():"";
            }

            @Override
            public User fromString(String s) {
                return null;
            }
        });
        txtName.setText(Session.getCurentGame().getName());
        txtCategory.setText(Session.getCurentGame().getCategory());
        txtBoxStatus.setText(Session.getCurentGame().getGameStatus());
        txtEnterprise.setText(Session.getCurentGame().getEnterprise());
        txtGameStatus.setText(Session.getCurentGame().getGameStatus());
        txtFormat.setText(Session.getCurentGame().getFormat());
        txtPlatform.setText(Session.getCurentGame().getPlatform());
        txtStudio.setText(Session.getCurentGame().getStudio());

        comboUser.getItems().addAll((new UserDAO().getAll()));

        comboUser.setValue(Session.getCurentGame().getUser());
    }

    @javafx.fxml.FXML
    public void save(ActionEvent actionEvent) {

        try(org.hibernate.Session s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            Game g = s.get(Game.class, Session.getCurentGame().getId());

            if(txtName.getText().length()>2) g.setName(txtName.getText());
            if(txtCategory.getText().length()>2) g.setCategory(txtCategory.getText());
            if(txtStudio.getText().length()>2) g.setStudio(txtStudio.getText());

            t.commit();

            Session.setCurentGame(g);
        }

    }

    @javafx.fxml.FXML
    public void delete(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void returnBack(ActionEvent actionEvent) {
    }
}