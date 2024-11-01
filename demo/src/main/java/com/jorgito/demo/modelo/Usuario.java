package com.jorgito.demo.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue
    Long id; // se usa un id para la normalizacion ya que las tablas se basan segun las clases

    @Column(unique = true)
    String email;

    
    String nombre;

    
    String apellido;

    
    int edad;

    int teléfono;

    @OneToMany(mappedBy = "autor")
    List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "dadorLike", cascade = CascadeType.REMOVE)
    List<LikePublicaciones> likesDados;
    
}
