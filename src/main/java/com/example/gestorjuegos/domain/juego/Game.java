package com.example.gestorjuegos.domain.juego;


import com.example.gestorjuegos.domain.usuario.User;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="coleccionjuegos")
public class Game implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="nombre")
  private String name;

  @Column(name="anio")
  private Long year;

  @Column(name="num_Jugadores")
  private Long players;

  @Column(name="categoria")
  private String category;

  @Column(name="plataforma")
  private String platform;

  @Column(name="estudio")
  private String studio;

  @Column(name="empresa")
  private String enterprise;

  @Column(name="formato")
  private String format;

  @Column(name="estado_Juego")
  private String gameStatus;

  @Column(name="estado_Caja")
  private String boxStatus;

//  @Column(name="usuario_id")
//  private Long usuarioId;

  @ManyToOne
  //la clave foranea
  @JoinColumn(name="usuario_id")
  //el atributo user va en el onetomany
  private User user;

  @Override
  public String toString() {
    return "Game{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", year=" + year +
            ", players=" + players +
            ", category='" + category + '\'' +
            ", platform='" + platform + '\'' +
            ", studio='" + studio + '\'' +
            ", enterprise='" + enterprise + '\'' +
            ", format='" + format + '\'' +
            ", gameStatus='" + gameStatus + '\'' +
            ", boxStatus='" + boxStatus + '\'' +
            ", user=" + user.getUsername() +
            '}';
  }
}
