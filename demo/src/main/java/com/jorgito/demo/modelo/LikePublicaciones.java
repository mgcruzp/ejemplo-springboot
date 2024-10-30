package com.jorgito.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "likesPublicaciones")
public class LikePublicaciones {
    
    @ManyToOne
    long idUser;

    @ManyToOne
    long idPublicaciones;
    
}
