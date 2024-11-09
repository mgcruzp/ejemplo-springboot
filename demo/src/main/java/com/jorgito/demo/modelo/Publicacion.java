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
    private long id; // id pa la normalizacion 

    
    private String informacion;

    @Column(unique = false, nullable = false)
    private String fecha ;
    
    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Comunidad comunidad;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.REMOVE)
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "likeado", cascade = CascadeType.REMOVE)
    private List<LikePublicaciones> likesRecibidos;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.REMOVE)
    private List<Video> videos;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.REMOVE)
    private List<Foto> fotos;

    
}
