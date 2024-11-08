package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Comentario;
import com.jorgito.demo.modelo.LikeComentarios;
import com.jorgito.demo.modelo.Usuario;

@Repository
public interface LikeComentariosRepository extends CrudRepository<LikeComentarios, Long >{

    LikeComentarios findByUsuarioAndComentario(Usuario usuario, Comentario comentario);

}
