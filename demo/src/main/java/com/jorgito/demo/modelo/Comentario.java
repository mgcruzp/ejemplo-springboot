package com.jorgito.demo.modelo;

import java.util.List;

import javax.swing.event.ListSelectionEvent;

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
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue
    long id;

    @Column(unique = false, nullable = false)
    String fecha ;


    @Column(unique = false, nullable = true)
    String descripcion;

    @ManyToOne
    Publicacion publicacion;

    @ManyToOne
    Usuario autor;

    @ManyToOne
    Comentario comentarioPadre;

    @OneToMany(mappedBy = "comentarioPadre")
    List<Comentario> comentarios;

    //List<LikeComentarios> likes;



}
