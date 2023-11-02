package com.example.gestorjuegos.domain.usuario;
//hay que modificar el pom y el module info

import com.example.gestorjuegos.domain.juego.Game;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
//serializable permite almacenar objetos complejos en bbdd

@Data
@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="usuario")
    private String username;

    @Column(name="contraseña")
    private String password;

    //el atributo en el que esta la clave foranea
    @OneToMany(mappedBy = "user")
    private ArrayList<Game> games = new ArrayList<>(0);

}
