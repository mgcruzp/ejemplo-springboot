package com.jorgito.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
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

}
