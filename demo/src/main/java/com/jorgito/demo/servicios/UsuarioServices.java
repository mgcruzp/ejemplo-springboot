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

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    Usuario registrarse( String nombre, int edad,  String email, String contra ){
        try {
            Usuario user= new Usuario();
            if(!(usuarioRepository.existsByEmail(email))){

                user.setContra(contra);
                user.setNombre(nombre);
                user.setEdad(edad);
                user.setEmail(email);
                return user;
               
            }else{
                throw new RuntimeException();
            }
        } catch (Exception e) {
            System.err.println("no se puede ingresar un email ya existente ");
            return null;
        }
        
    }
    
}
