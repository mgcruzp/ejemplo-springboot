package com.jorgito.demo.servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.Comentario;
import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.PublicacionRepository;
import com.jorgito.demo.repositorio.UsuarioRepository;

// Casos de Uso de Publicaciones
@Service
public class PublicacionService {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    ComentarioService comentarioService;
    
     Publicacion publicar(Usuario autor, String informacion, Comunidad comunidad) 
        throws JorgitoException
    {
        try {
            // 1. valida que no el texto no este vacio
            if (informacion == null || informacion.equals(""))
            throw new Exception("la informacion de la publicacion está vacia");

            // 2. guarda
            Publicacion publicacion = new Publicacion() ;
            publicacion.setAutor(autor);
            publicacion.setInformacion(informacion);
            publicacion.setComunidad(comunidad);
            
            LocalDateTime fechaActual = LocalDateTime.now();
        
            // Define el formato deseado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
            // Convierte LocalDateTime a String
             String fechaFormateada = fechaActual.format(formatter);
        
            publicacion.setFecha(fechaFormateada);
            
            publicacionRepository.save(publicacion);
            return publicacion;

        } catch (Exception e) {

            throw new JorgitoException("Problema al publicar", e);
        }
    }

    Comentario agregarComentario(Publicacion publicacion, Usuario autor, String descripcion)
    throws JorgitoException
    {
        try {
            
            if (!publicacionRepository.existsById(publicacion.getId()))
                throw new JorgitoException("No existe la publicacion a la que se quiere agregar el comentario");

            Comentario comentario = comentarioService.crearComentario(autor, publicacion, descripcion);

            
            List<Comentario> comentariosPubli = publicacion.getComentarios();
            
            comentariosPubli.add(comentario);
            
            publicacion.setComentarios(comentariosPubli);

            publicacionRepository.save(publicacion);

            
            return comentario;
            

        } catch (Exception e) {

            throw new JorgitoException("Problema al publicar", e);
        }
    }

    Comentario agregarComentarioAComentario(Publicacion publicacion, Usuario autor, String descripcion, Comentario comentario)
    throws JorgitoException
    {
        try {

            if(!publicacion.getComentarios().contains(comentario)) 
                throw new JorgitoException("No existe la publicacion donde se quiere comentar");
            if (!publicacionRepository.existsById(publicacion.getId()))
                throw new JorgitoException("No existe la publicacion donde se quiere comentar");

            Comentario comentarioDelComentario = comentarioService.comentarComentario( comentario, autor,  publicacion, descripcion);

            
            List<Comentario> comentariosPubli = publicacion.getComentarios();

            int idPadre =comentariosPubli.indexOf(comentario);
            comentariosPubli.remove(idPadre);
            comentariosPubli.add(comentarioDelComentario.getComentarioPadre());
            comentariosPubli.add(comentarioDelComentario);
            publicacion.setComentarios(comentariosPubli);
            publicacionRepository.save(publicacion);

            
            return comentario;
            

        } catch (Exception  e) {

            throw new JorgitoException("Problema al publicar", e);
        }
    }
}