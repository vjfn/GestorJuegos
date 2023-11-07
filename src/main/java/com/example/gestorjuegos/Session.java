package com.example.gestorjuegos;

import com.example.gestorjuegos.domain.juego.Game;
import com.example.gestorjuegos.domain.usuario.User;

import lombok.*;


public class Session {
    @Getter
    @Setter
    private static User curentUser;
    @Getter
    @Setter
    private static Game curentGame;


}
