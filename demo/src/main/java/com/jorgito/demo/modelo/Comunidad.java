package com.jorgito.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "comunidad")
public class Comunidad {

    @Id
    @GeneratedValue
    long id;

    @Column(unique = false, nullable = false)
    String fecha ;

    @Column(unique = false, nullable = false)
    String nombre;

    @OneToMany(mappedBy = "comunidad")
    List<Publicacion> publicaciones;
}
