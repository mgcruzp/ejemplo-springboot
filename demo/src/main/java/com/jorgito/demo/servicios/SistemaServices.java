package com.jorgito.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.Comentario;
import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Inscripciones;
import com.jorgito.demo.modelo.Publicacion;
import com.jorgito.demo.modelo.Usuario;
import com.jorgito.demo.repositorio.UsuarioRepository;

@Service
public class SistemaServices {

    Usuario usuarioActivo;
    Comunidad comunidadActiva;
    
    
    UsuarioServices usuarioServices;
  
    
    ComunidadServices comunidadServices;

    @Autowired
    UsuarioRepository usuarioRepository;
     
    
    PublicacionService publicacionService;


    void inicioSesion(String email, String contra) 
        throws JorgitoException
    {
        try {
            usuarioActivo = usuarioServices.iniciarSesion(email, contra);
        } catch (Exception e) {
            throw new JorgitoException( "Error al iniciar sesion", e);
        }

    }

    void registrarse( String nombre, int edad,  String email, String contra )
     throws JorgitoException
     {
        try {
            usuarioActivo= usuarioServices.registrarse(nombre, edad, email, contra);
        } catch (Exception e) {
            throw new JorgitoException( "Error al registrarse", e);
        }
        

    }
    
    void cerrarSesion(){
        usuarioActivo=usuarioServices.cerrarSesion();
    }

    void crearComunidad(String nombre, String descripcion)
    throws JorgitoException
    {
        try {
            List<Inscripciones> inscripciones = usuarioActivo.getInscripciones();
            Inscripciones i = comunidadServices.crearComunidad(nombre,descripcion, usuarioActivo);
            inscripciones.add(i);
            usuarioRepository.save(usuarioActivo);
        } catch (Exception e) {
            throw new JorgitoException( "Error al registrarse", e);
        }
        
    }
    
    void entrarAComunidad(String nombreC)
    throws JorgitoException
    {
        try {
            List<Inscripciones> inscripciones = usuarioActivo.getInscripciones();
            Inscripciones i = comunidadServices.entrarAComunidad(nombreC, usuarioActivo);
            inscripciones.add(i);
            usuarioRepository.save(usuarioActivo);
        } catch (Exception e) {
            throw new JorgitoException( "Error al registrarse", e);
        }
        
    }
    

 
    void seleccionarComunidad(Comunidad c)
    throws JorgitoException
    {
        try {

            comunidadActiva=usuarioServices.seleccionarComunidad(c, usuarioActivo);

            
        } catch (Exception e) {
            throw new JorgitoException( "Error al registrarse", e);
        }
        
    }

    void editarNombre(String nuevoNombre){

        usuarioActivo =usuarioServices.editarNombre( usuarioActivo , nuevoNombre);
    }

    void editarApellido( String apellido){

        usuarioActivo =usuarioServices.editarApellido( usuarioActivo , apellido);
    }
    void editarTelefono( int telefono){

        usuarioActivo =usuarioServices.editarTelefono( usuarioActivo , telefono);
    }
    void editarContra(String contra, String contraActual)
        throws JorgitoException
    {
        usuarioActivo =usuarioServices.editarContra( usuarioActivo , contra, contraActual);
        
    }


    void editarEdad( int edad){

        usuarioActivo=usuarioServices.editarEdad( usuarioActivo , edad);
    }
    


    void editarEmail( String email)
        throws JorgitoException
    {
        usuarioActivo =usuarioServices.editarEmail( usuarioActivo , email);
    }

    void agregarPublicacion(String informacion)    
    throws JorgitoException
    {
        Publicacion p =publicacionService.publicar(usuarioActivo, informacion, comunidadActiva);
        usuarioActivo = usuarioServices.agregarPublicacion(usuarioActivo, p);
    }

    void agregarComentario (Publicacion publicacion,  String descripcion)
    throws JorgitoException
    {
        try {

            
            Comentario comentario = publicacionService.agregarComentario(publicacion, usuarioActivo, descripcion);

            List<Comentario> comentariosUser = usuarioActivo.getComentarios();
            comentariosUser.add(comentario);
            usuarioActivo.setComentarios(comentariosUser);
            usuarioRepository.save(usuarioActivo);

            
        } catch (Exception e) {
            throw new JorgitoException( "Error al agregar comentario", e);
        }
        
    }

    void agregarComentarioAComentario (Publicacion publicacion,  String descripcion)
    throws JorgitoException
    {
        try {

            
            Comentario comentario = publicacionService.agregarComentario(publicacion, usuarioActivo, descripcion);

            List<Comentario> comentariosUser = usuarioActivo.getComentarios();
            comentariosUser.add(comentario);
            usuarioActivo.setComentarios(comentariosUser);
            usuarioRepository.save(usuarioActivo);

            
        } catch (Exception e) {
            throw new JorgitoException( "Error al comentar un comentario", e);
        }
        
    }
}
