package com.jorgito.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "likesComentario")
public class LikeComentarios {
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    Usuario usuario;

    @ManyToOne
    Comentario comentario;
}
