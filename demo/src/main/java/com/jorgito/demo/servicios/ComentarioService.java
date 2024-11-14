package com.jorgito.demo.servicios;

import com.jorgito.demo.modelo.Publicacion;

import java.util.List;

import com.jorgito.demo.modelo.Comentario;
import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.ComentarioRepository;

public class ComentarioService {

    
    ComentarioRepository comentarioRepository;
    //crear comentario

    Comentario crearComentario(Usuario autor, Publicacion publicacion,String descripcion)
    throws JorgitoException
    {
            try {
                Comentario comentario = new Comentario();
                comentario.setAutor(autor);
                comentario.setPublicacion(publicacion);
                comentario.setDescripcion(descripcion); 
                comentario.setComentarioPadre( null);

                comentarioRepository.save(comentario);

                
                return comentario;


            } catch (Exception e) {
                throw new JorgitoException("error al crear comentario en Comentario", e);
            }

    }
    
    Comentario comentarComentario(Comentario comentario, Usuario autor, Publicacion publicacion,String descripcion)
    throws JorgitoException
    {
        try {
                Comentario comentarioo= crearComentario(autor, publicacion, descripcion);  
                comentarioo.setComentarioPadre(comentario);
                List<Comentario> c = comentario.getComentarios();
                c.add(comentarioo);
                comentario.setComentarios(c);
                comentarioRepository.save(comentarioo);
                comentarioRepository.save(comentario);
                return comentario;
        } catch (Exception e) {
            throw new JorgitoException("error al crear comentario que comenta comentario en Comentario", e);
        }

    }

}