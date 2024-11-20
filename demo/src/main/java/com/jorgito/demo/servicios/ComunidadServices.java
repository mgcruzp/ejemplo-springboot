
package com.jorgito.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Inscripciones;
import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.ComunidadRepository;
import com.jorgito.demo.repositorio.InscripcionesRepository;

@Service
public class ComunidadServices {

    @Autowired
    ComunidadRepository comunidadRepository;

    @Autowired
    InscripcionesRepository inscripcionesRepository;

    Comunidad crearComunidad(String nombre, String descripcion, Usuario creador) 
        throws JorgitoException 
    {
        try {
            //1. verificar que el nombre no este en uso
            if(comunidadRepository.existsByNombre(nombre))
                throw new JorgitoException("Ya existe una comunidad con ese nombre");

            //2. verificar que el nombre no este vacío
            if (nombre == null || nombre.equals(""))
                throw new JorgitoException("El nombre de la comunidad está vacío");

            //3. verificar que la descripcion no este vacia
            if (descripcion == null || descripcion.equals(""))
                throw new JorgitoException("La descripción de la comunidad está vacía");

            Comunidad comunidad = new Comunidad();
            comunidad.setNombre(nombre);
            comunidad.setDescripcion(descripcion);
    

            comunidadRepository.save(comunidad);
            return comunidad;

        } catch (Exception e) {
            throw new JorgitoException("Error al crear la comunidad", e);
        }
    }

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

    Inscripciones entrarAComunidad(String nombreC, Usuario usuario)
    throws JorgitoException
    {
        try {
            //1. verificar que el id exista
            if(!comunidadRepository.existsByNombre(nombreC))
                throw new JorgitoException("No hay comunidad con dicho nombre");

            //2. verificar si la comunidad hace parte del usuario
            Inscripciones inscripciones = new Inscripciones();
            
            Comunidad c = comunidadRepository.findByNombre(nombreC);

            inscripciones.setUsuario(usuario);
            inscripciones.setComunidad(c);
            inscripcionesRepository.save(inscripciones);
            return inscripciones;
        } catch (Exception e) {
            throw new JorgitoException("Error al entrar a una comunidad", e );
        }

    }

}
