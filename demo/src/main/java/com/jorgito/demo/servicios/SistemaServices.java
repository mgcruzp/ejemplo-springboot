package com.jorgito.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    void editarNombre( Usuario usuario ,String nuevoNombre){

        usuarioActivo =usuarioServices.editarNombre( usuario , nuevoNombre);
    }

    void editarApellido( Usuario usuario ,String apellido){

        usuarioActivo =usuarioServices.editarApellido( usuario , apellido);
    }
    void editarTelefono( Usuario usuario ,int telefono){

        usuarioActivo =usuarioServices.editarTelefono( usuario , telefono);
    }
    void editarContra( Usuario usuario ,String contra, String contraActual)
        throws JorgitoException
    {
        usuarioActivo =usuarioServices.editarContra( usuario , contra, contraActual);
        
    }


    void editarEdad( Usuario usuario ,int edad){

        usuarioActivo=usuarioServices.editarEdad( usuario , edad);
    }
    


    void editarEmail( Usuario usuario ,String email)
        throws JorgitoException
    {
        usuarioActivo =usuarioServices.editarEmail( usuario , email);
    }

    void agregarPublicacion(String informacion)    
    throws JorgitoException
    {
        Publicacion p =publicacionService.publicar(usuarioActivo, informacion, comunidadActiva);
        usuarioActivo = usuarioServices.agregarPublicacion(usuarioActivo, p);
    }

}
