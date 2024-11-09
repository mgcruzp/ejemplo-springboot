package com.jorgito.demo.servicios;

import java.util.List;

import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.repositorio.ComunidadRepository;

public class ComunidadServices {

    ComunidadRepository comunidadRepository;

    
    //0. crear comunidad
    //1. verificar que el nombre no este en uso
    //2. verificar que la descripcion no este vacia


    Comunidad agregarPublicacion(Publicacion publicacion, Comunidad comunidad)
    throws JorgitoException
    {
        
        try {

            //1. comprobar que no este subida la publicacion antes en la comunidad
            if((comunidad.getPublicaciones()).contains(publicacion))
                throw new JorgitoException("esta publicacion ya esta registrada en la comunidad");

            List<Publicacion> publis =comunidad.getPublicaciones();

            publis.add(publicacion);

            comunidad.setPublicaciones(publis);

            comunidadRepository.save(comunidad);

            return comunidad;
        } catch (Exception e) {
            throw new JorgitoException("Problema al publicar en la comunidad", e);
        }

    }

}
