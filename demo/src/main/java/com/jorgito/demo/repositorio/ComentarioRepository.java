package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Comentario;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long>{
    Comentario findById(long id);

    // Verificar si existe un usuario por email
    boolean existsById(Long id);
}
