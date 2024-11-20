package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.LikeComentarios;

@Repository
public interface LikeComentariosRepository extends CrudRepository<LikeComentarios, Long >{
    //boolean existsByUsuarioAndComentario(Usuario usuario, Comentario comentario);
    //LikeComentarios findByUsuarioAndComentario(Usuario usuario, Comentario comentario);
}
