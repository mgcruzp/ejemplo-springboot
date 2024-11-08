package com.jorgito.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.repositorio.UsuarioRepository;

// Casos de Uso de Publicaciones
@Service
public class PublicacionesService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // publicar
    // 1. ingresa el email
    // 2. valida que el email existe
    // 3. ingresa la publicacion
    // 4. valida que el texto no este vacio
    // 5. guarda la nueva publicacion
    /* 
    public Publicacion publicar(String email, String texto) 
        throws JorgitoException
    {

        // 2. valida que el email  exista
        if (! usuarioRepository.existsByEmail(email))
            throw new Exception("no existe un usuario con ese email");

        // 4. valida que no el texto no este vacio
        if (texto == null || texto.equals(""))
            throw new Exception("El texto está vacio");

        // 5. guarda
        

    }

*/
}
