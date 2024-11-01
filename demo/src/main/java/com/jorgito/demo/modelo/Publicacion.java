package com.jorgito.demo.modelo;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "publicaciones")
public class Publicacion {
    @Id  
    @GeneratedValue
    long id; // id pa la normalizacion 

    
    String informacion;


    @Temporal(TemporalType.TIMESTAMP)
    Date fecha ;
    
    @ManyToOne
    Usuario user;

    @OneToMany(mappedBy = "likeado", cascade = CascadeType.REMOVE)
    List<LikePublicaciones> likesRecibidos;
}
