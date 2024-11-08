package com.jorgito.demo.repositorio;
import org.springframework.data.repository.CrudRepository;

import com.jorgito.demo.modelo.Comunidad;

public interface ComunidadRepository extends CrudRepository<Comunidad, Long> {

    // Buscar por email
    Comunidad findByNombre(String nombre);

    // Verificar si existe un usuario por email
    boolean existsByNombre(String nombre);
}
