package com.jorgito.demo.servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.PublicacionRepository;

// Casos de Uso de Publicaciones
@Service
public class PublicacionService {

    @Autowired
    PublicacionRepository publicacionRepository;

    
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
    
    //Publicacion agregarComentario(){
            
    

    //}
}
