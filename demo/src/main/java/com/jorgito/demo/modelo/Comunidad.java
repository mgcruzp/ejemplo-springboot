package com.jorgito.demo.modelo;

import java.util.List;

import org.springframework.beans.factory.support.RegisteredBean.InstantiationDescriptor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "comunidades")
public class Comunidad {

    @Id
    @GeneratedValue
    long id;

    @Column(unique = false, nullable = false)
    String fecha ;

    @Column(unique = false, nullable = false)
    String nombre;

    @Column(unique = false, nullable = true)
    String descripcion;

    
    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.REMOVE)
    List<Inscripciones> inscritos;

    @OneToMany(mappedBy = "comunidad", cascade = CascadeType.REMOVE)
    List<Publicacion> publicaciones;
}
