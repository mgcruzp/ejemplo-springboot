package com.jorgito.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Persona {

    @Id
    Long id;

    @Column(unique = true, nullable = false)
    String email;

    String nombre;

}
