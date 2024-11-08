package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Comentario;
import com.jorgito.demo.modelo.LikePublicaciones;
import com.jorgito.demo.modelo.Usuario;

@Repository
public interface LikePublicacionesRepository extends CrudRepository<LikePublicaciones, Long> {

    LikePublicaciones findByDadorLikeAndLikeado(Usuario dadorLike, Comentario likeado);
}
