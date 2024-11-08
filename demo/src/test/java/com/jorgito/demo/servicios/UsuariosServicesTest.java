package com.jorgito.demo.servicios;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jorgito.demo.repositorio.UsuarioRepository;

@SpringBootTest
public class UsuariosServicesTest {

    @Autowired
    UsuarioServices usuarioServices;

    @Autowired
    UsuarioRepository usuarioRepository;

    @BeforeEach
    public void borrarUsuarios()  {
        usuarioRepository.deleteAll();
    }

    @Test
    public void agregaUsuarioSinError() {
        try {
            usuarioServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            // ok
        } catch (Exception e) {
            fail("no dejo grabar con todos los datos bien");
        }
    }

    @Test
    public void agregaUsuarioSinNombreDebeFallar() {
        try {
            usuarioServices.registrarse(null,20, "otro@ejemplo.com", "secret");
            fail("Dejo guardar sin nombre");

        } catch (Exception e) {
            // OK
        }
    }

    // ==

    @Test
    public void iniciarSesionConUsuarioQueExiste() {

        try {
            
            usuarioServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");

            usuarioServices.iniciarSesion("jaime@ejemplo.com", "secret");

            // ok

        } catch (Exception e) {
            fail("no dejo iniciar sesion");
        }

    }

}
