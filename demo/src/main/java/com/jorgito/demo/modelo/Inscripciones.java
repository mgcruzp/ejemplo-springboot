package com.jorgito.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "inscripciones")
public class Inscripciones {
        
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    Usuario usuario;

    @ManyToOne
    Comunidad comunidad;
    
}
