package com.jorgito.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.UsuarioRepository;



public class UsuarioServices {
    @Autowired
    UsuarioRepository usuarioRepository;


    Usuario iniciarSesion(String email, String contra){
        if(usuarioRepository.existsByEmail(email)){
            Usuario newUser = usuarioRepository.findByEmail(email);
            
            // Si el usuario está presente
            if (newUser != null) {
                
                // Verifica si la contraseña es correcta
                if (newUser.getContra().equals(contra)) {

                    return newUser;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    Usuario registrarse( String nombre, int edad, int telefono , String email, String contra ){
        Usuario user= new Usuario();
        if(!(usuarioRepository.existsByEmail(email))){

            user.setContra(contra);
            user.setNombre(nombre);
            user.setEdad(edad);
            user.setEmail(email);
            user.setTelefono(telefono);
            return user;
               
        }else{
            return null;
        }
    }
}
