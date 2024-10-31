package com.jorgito.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "likesPublicaciones")
public class LikePublicaciones {
    
    @Id
    long id;

    @ManyToOne
    long idUser;

    @ManyToOne
    long idPublicaciones;
    
}
