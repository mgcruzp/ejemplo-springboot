package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.jorgito.demo.modelo.LikePublicaciones;
import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.modelo.Usuario;

@Repository
public interface LikePublicacionesRepository extends CrudRepository<LikePublicaciones, Long> {
    //LikePublicaciones findByUsuarioAndPublicacion(Usuario usuario, Publicacion publicacion);
    //boolean existsByUsuarioAndPublicacion(Usuario usuario, Publicacion publicacion);
}
