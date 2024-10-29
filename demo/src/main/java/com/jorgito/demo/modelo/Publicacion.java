package com.jorgito.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Publicacion {
    @Id  
    long id; // id pa la normalizacion 

    @Column(unique = true, nullable = true)
    String informacion;

    @Column(unique = true, nullable = true)
    String fecha ;
    

}
