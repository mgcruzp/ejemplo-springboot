  package com.jorgito.demo.repositorio;

import org.springframework.data.repository.kotlin.CoroutineCrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Publicacion;

@Repository
public interface PublicacionRepository extends CoroutineCrudRepository<Publicacion, Long> {
    Publicacion findById(Long id);

    // Verificar si existe un usuario por email
    boolean existsById(Long id);
}
