package com.jorgito.demo.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue
    Long id; // se usa un id para la normalizacion ya que las tablas se basan segun las clases

    @Column(unique = true, nullable = false) // va a ser un atributo de la tabla 
    String email;

    @Column(unique = true, nullable = false)
    String nombre;

    @Column(unique = true, nullable = false)
    String apellido;

    @Column(unique = true, nullable = false)
    int edad;

    @Column(unique = true, nullable = true)
    int teléfono;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.REMOVE)
    List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "likesDados", cascade = CascadeType.REMOVE)
    List<LikePublicaciones> likesDados;
    
}
