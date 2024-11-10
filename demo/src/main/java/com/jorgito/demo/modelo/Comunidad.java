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
@Table(name = "comunidades")
public class Comunidad {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = false, nullable = false)
    private String fecha ;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = false, nullable = true)
    private String descripcion;

    
    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.REMOVE)
    private List<Inscripciones> inscritos;

    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.REMOVE)
    private List<Publicacion> publicaciones;
}
