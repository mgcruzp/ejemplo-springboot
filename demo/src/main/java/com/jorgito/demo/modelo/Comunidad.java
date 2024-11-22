package com.jorgito.demo.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private LocalDateTime fecha= LocalDateTime.now(); 

    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(unique = false, nullable = true)
    private String descripcion;

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.REMOVE)
    private List<Inscripciones> inscritos= new ArrayList();

    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.REMOVE)
    private List<Publicacion> publicaciones;
}
