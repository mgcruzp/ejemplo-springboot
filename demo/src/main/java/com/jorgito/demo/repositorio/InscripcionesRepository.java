package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Inscripciones;
import com.jorgito.demo.modelo.Usuario;

@Repository
public interface InscripcionesRepository extends CrudRepository<Inscripciones, Long>{

    Inscripciones findByUsuarioAndComunidad(Usuario usuario, Comunidad comunidad);
}
