package com.jorgito.demo.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = false, nullable = false)
    private LocalDateTime fecha= LocalDateTime.now();


    @Column(unique = false, nullable = true)
    private String descripcion;

    @ManyToOne
    Publicacion publicacion;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Comentario comentarioPadre;

    @OneToMany(mappedBy = "comentarioPadre", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "comentario", cascade = CascadeType.REMOVE)
    private List<LikeComentarios> likes;



}
