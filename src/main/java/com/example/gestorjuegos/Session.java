package com.example.gestorjuegos;

import com.example.gestorjuegos.domain.usuario.User;

import lombok.*;


public class Session {

    @Getter
    @Setter
    private static User curentUser;


}
