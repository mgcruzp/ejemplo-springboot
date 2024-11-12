package com.jorgito.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.LikeComentarios;
import com.jorgito.demo.modelo.LikePublicaciones;
import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.modelo.Comentario;
import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.LikeComentariosRepository;
import com.jorgito.demo.repositorio.LikePublicacionesRepository;

@Service
public class LikeServices {
    
    @Autowired
    LikePublicacionesRepository likePublicacionesRepository;

    @Autowired
    LikeComentariosRepository likeComentariosRepository;

    public LikePublicaciones darLikePublicacion(Usuario usuario, Publicacion publicacion) 
        throws JorgitoException 
    {
        try {
            // Verificar que no haya dado like antes
            if(likePublicacionesRepository.existsByUsuarioAndPublicacion(usuario, publicacion))
                throw new JorgitoException("Ya le diste like a esta publicación");

            LikePublicaciones like = new LikePublicaciones();
            like.setDadorLike(usuario);
            like.setLikeado(publicacion);

            likePublicacionesRepository.save(like);
            return like;

        } catch (Exception e) {
            throw new JorgitoException("Error al dar like a la publicación", e);
        }
    }

    public void quitarLikePublicacion(Usuario usuario, Publicacion publicacion) 
        throws JorgitoException 
    {
        try {
            // Verificar que exista el like
            LikePublicaciones like = likePublicacionesRepository.findByUsuarioAndPublicacion(usuario, publicacion);

            if(like == null)
                throw new JorgitoException("No has dado like a esta publicación");

            likePublicacionesRepository.delete(like);

        } catch (Exception e) {
            throw new JorgitoException("Error al quitar like de la publicación", e);
        }
    }

    public LikeComentarios darLikeComentario(Usuario usuario, Comentario comentario) 
        throws JorgitoException 
    {
        try {
            // Verificar que no haya dado like antes
            if(likeComentariosRepository.existsByUsuarioAndComentario(usuario, comentario))
                throw new JorgitoException("Ya le diste like a este comentario");

            LikeComentarios like = new LikeComentarios();
            like.setUsuario(usuario);
            like.setComentario(comentario);

            likeComentariosRepository.save(like);
            return like;

        } catch (Exception e) {
            throw new JorgitoException("Error al dar like al comentario", e);
        }
    }

    public void quitarLikeComentario(Usuario usuario, Comentario comentario) 
        throws JorgitoException 
    {
        try {
            // Verificar que exista el like
            LikeComentarios like = likeComentariosRepository.findByUsuarioAndComentario(usuario, comentario);

            if(like == null)
                throw new JorgitoException("No has dado like a este comentario");

            likeComentariosRepository.delete(like);

        } catch (Exception e) {
            throw new JorgitoException("Error al quitar like del comentario", e);
        }
    }
}