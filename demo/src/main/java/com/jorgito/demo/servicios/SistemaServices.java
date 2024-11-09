package com.jorgito.demo.servicios;

import org.springframework.stereotype.Service;

import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.modelo.Usuario;

@Service
public class SistemaServices {

    Usuario usuarioActivo;
    Comunidad comunidadActiva;
    UsuarioServices usuarioServices;

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
    
    
}
