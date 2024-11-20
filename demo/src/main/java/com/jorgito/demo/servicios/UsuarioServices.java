package com.jorgito.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Inscripciones;
import com.jorgito.demo.modelo.Publicacion;
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

    Usuario cerrarSesion(){
        Usuario user =new Usuario();
            
            user.setContra("1");
            user.setNombre("1");
            user.setEdad(1);
            user.setEmail("1");               
            
            return user;
        
    }

    Usuario editarNombre( Usuario usuario ,String nuevoNombre){

        usuario.setNombre(nuevoNombre);
        usuarioRepository.save(usuario);
        return usuario;
    }
    
    Usuario editarApellido( Usuario usuario ,String apellido){

        usuario.setApellido(apellido);
        usuarioRepository.save(usuario);
        return usuario;
    }
    Usuario editarTelefono( Usuario usuario ,int telefono){

        usuario.setTelefono(telefono);
        usuarioRepository.save(usuario);
        return usuario;
    }
    Usuario editarContra( Usuario usuario ,String contra, String contraActual)
        throws JorgitoException
    {
        try {
            //1. Verificacion de contraseñas
            if(!((usuario.getContra()).equals(contraActual))){
                throw new JorgitoException("no se ingreso la contraseña actual de manera correcta");
            }
            usuario.setContra(contra);
            usuarioRepository.save(usuario);
            return usuario;
        } catch (Exception e) {
            throw new JorgitoException("hubo un error al cambiar contrasenia", e);
        }
        
    }


    Usuario editarEdad( Usuario usuario ,int edad){

        usuario.setEdad(edad);
        usuarioRepository.save(usuario);
        return usuario;
    }
    


    Usuario editarEmail( Usuario usuario ,String email)
        throws JorgitoException
    {
        try {
            //1. Verificar si el email ya esta en uso
            if(usuarioRepository.existsByEmail(email)){
                throw new JorgitoException("el correo ya esta siendo utilizado");
            }
            usuario.setEmail(email);
                
            return usuario;
        } catch (Exception e) {
            throw new JorgitoException("hubo un error al cambiar correo", e);
        }
    }

    Usuario QuitarPublicacion(long idPublicacion, Usuario usuario)
        throws JorgitoException    
    {
        try {
            boolean existe = false;
            List<Publicacion> publis=  usuario.getPublicaciones();

            //1. verificar que exista la publicacion en lista

            for(Publicacion p : publis){

                if((p.getId()) == idPublicacion ){
                    publis.remove(p);
                    existe= true;
                    break;
                }
            }

            if(existe == false)
                throw new JorgitoException("En la lista del usuario no aparece esta publicacion");

            usuario.setPublicaciones(publis);
            
            return usuario;

        } catch (Exception e) {
            throw new JorgitoException("hubo un  al quitar publicacion", e);
        }

    }

    Usuario agregarPublicacion(Usuario usuario, Publicacion publicacion)
    throws JorgitoException    
    {
        try {
            boolean existe = false;
            List<Publicacion> publis=  usuario.getPublicaciones();

            //1. verificar que no exista la publicacion en lista

            for(Publicacion p : publis){

                if((p.getId()) == publicacion.getId() ){
                    existe= true;
                    break;
                }
            }

            if(existe == true)
                throw new JorgitoException("En la lista del usuario  aparece  publicacion cuando ya se agrego");

            publis.add(publicacion);
            usuario.setPublicaciones(publis);

            usuarioRepository.save(usuario);
            return usuario;

        } catch (Exception e) {
            throw new JorgitoException("hubo un  al agregar publicacion", e);
        }

    }

    Comunidad seleccionarComunidad(Comunidad c, Usuario usuario)
    throws JorgitoException
    {
        try {
            boolean flag = true;
            for(Inscripciones i : usuario.getInscripciones() ){

                if(i.getComunidad().equals(c));
                    flag= false;
                    return i.getComunidad();
            }
            if(flag)
                throw new JorgitoException("no existe la comunidad dentro de tus comunidades");
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return c;
    }

}