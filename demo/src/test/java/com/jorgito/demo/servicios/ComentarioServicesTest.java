package com.jorgito.demo.servicios;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jorgito.demo.repositorio.ComentarioRepository;
import com.jorgito.demo.repositorio.PublicacionRepository;
import com.jorgito.demo.repositorio.UsuarioRepository;

@SpringBootTest
public class ComentarioServicesTest {
    @Autowired
    SistemaServices sistemaServices;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    PublicacionRepository publicacionRepository;

    @BeforeEach
    public void borrarUsuarios()  {
        usuarioRepository.deleteAll();
        comentarioRepository.deleteAll();
        publicacionRepository.deleteAll();
    }

    @Test
    public void crearComentario() {
        try {
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            // ok
        } catch (Exception e) {
            fail("no dejo grabar con todos los datos bien");
        }
    }

    @Test
    public void crearComentarioVacio() {
        try {
            sistemaServices.registrarse(null,20, "otro@ejemplo.com", "secret");
            fail("Dejo guardar sin nombre");

        } catch (Exception e) {
            // OK
        }
    }

    // ==

}
