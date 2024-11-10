package com.jorgito.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "likePublicaciones")
public class LikePublicaciones {
    
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Usuario dadorLike;

    @ManyToOne
    private Publicacion likeado;
    
}
