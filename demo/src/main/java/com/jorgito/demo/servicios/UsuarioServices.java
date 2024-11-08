package com.jorgito.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.UsuarioRepository;


// Casos de uso relacionados con usuarios
@Service
public class UsuarioServices {

    @Autowired
    UsuarioRepository usuarioRepository;


    
    Usuario iniciarSesion(String email, String contra)
        throws JorgitoException
    {

        // validaciones

        // 1. verifica que exista un usuario con ese email

        Usuario usuarioConEseEmail = usuarioRepository.findByEmail(email);
        
        if (usuarioConEseEmail == null)
            throw new JorgitoException("no existe ese usuario");

        // 2. verifica que el password coincida

        if (!contra.equals(usuarioConEseEmail.getContra()))
            throw new JorgitoException("la contraseña está errada");


        return usuarioConEseEmail;
    }


    Usuario registrarse( String nombre, int edad,  String email, String contra )
        throws JorgitoException
    {

        try {

            // validaciones

            // 1. Validar que el nombre no esté vacio
            if (nombre == null || nombre.equals("")) 
                throw new JorgitoException("El nombre está vacio");

            // 2. Validar que la edad sea mayor o igual a 18
            if (edad < 18)
                throw new JorgitoException("La edad es menor a 18");

            // 3. validar que no exista otro usuario con ese email
            if (usuarioRepository.existsByEmail(email))
                throw new JorgitoException("Ya existe otro usuario con ese email");

            // 4. validar que la contraseña no esté vacia
            if (contra == null || contra.equals(""))
                throw new JorgitoException("la contraseña está vacía");


            // 5. Guarda el nuevo usuario

            Usuario user =new Usuario();
            
            user.setContra(contra);
            user.setNombre(nombre);
            user.setEdad(edad);
            user.setEmail(email);               
            
            user = usuarioRepository.save(user);
            return user;


        } catch (Exception e) {
            throw new JorgitoException("No se pudo grabar", e);
        }
        
    }
    
}
