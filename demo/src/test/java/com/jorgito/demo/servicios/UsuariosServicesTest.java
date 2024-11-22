package com.jorgito.demo.servicios;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.format.SignStyle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jorgito.demo.repositorio.UsuarioRepository;

@SpringBootTest
public class UsuariosServicesTest {

    @Autowired
    SistemaServices sistemaServices;

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
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            // ok
        } catch (Exception e) {
            fail("no dejo grabar con todos los datos bien",e);
        }
    }

    @Test
    public void agregaUsuarioSinNombreDebeFallar() {
        try {
            sistemaServices.registrarse(null,20, "otro@ejemplo.com", "secret");
            fail("Dejo guardar sin nombre");

        } catch (Exception e) {
            // OK
        }
    }

    // ==

    @Test
    public void iniciarSesionConUsuarioQueExiste() {

        try {
            
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");

            sistemaServices.inicioSesion("jaime@ejemplo.com", "secret");
            // ok

        } catch (Exception e) {
            fail("no dejo iniciar sesion");
        }

    }

}
