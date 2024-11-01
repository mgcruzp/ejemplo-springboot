package com.jorgito.demo.modelo;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "segumientos")
public class LikePublicaciones {
    
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    Usuario dadorLike;

    @ManyToOne
    Publicacion likeado;
    
}
