  package com.jorgito.demo.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jorgito.demo.modelo.Publicacion;

@Repository
public interface PublicacionRepository extends CrudRepository<Publicacion, Long> {
    Publicacion findById(long id);

    // Verificar si existe un usuario por email
    boolean existsById(long id);
}

