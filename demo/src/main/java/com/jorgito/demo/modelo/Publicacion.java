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
@Table(name = "publicaciones")
public class Publicacion {
    @Id  
    @GeneratedValue
    long id; // id pa la normalizacion 

    
    String informacion;

    @Column(unique = false, nullable = false)
    String fecha ;
    
    @ManyToOne
    Usuario autor;

    @ManyToOne
    Comunidad comunidad;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.REMOVE)
    List<Comentario> comentarios;

    @OneToMany(mappedBy = "likeado", cascade = CascadeType.REMOVE)
    List<LikePublicaciones> likesRecibidos;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.REMOVE)
    List<Video> videos;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.REMOVE)
    List<Foto> fotos;
}
