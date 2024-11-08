package com.jorgito.demo.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Foto;

@Repository
public interface FotoRepository extends CrudRepository<Foto,Long>{
    Foto findById(long id);

    // Verificar si existe un usuario por email
    boolean existsById(long id);
}
