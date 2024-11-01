package com.jorgito.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "fotos")
public class Foto {
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    Publicacion publicacion;
}
