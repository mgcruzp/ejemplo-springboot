package com.jorgito.demo.servicios;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jorgito.demo.modelo.Publicacion;
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
            sistemaServices.crearComunidad("nombre" ,"desc");
            sistemaServices.agregarPublicacion("descPubli");
            Publicacion p =publicacionRepository.findById(1);
            sistemaServices.agregarComentario(p, "descddd");
            // ok
        } catch (Exception e) {
            fail("no se pudo comentar sin errores",e);
        }
    }

    @Test
    public void crearComentarioVacio() {
        try {
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            sistemaServices.crearComunidad("nombre" ,"desc");
            sistemaServices.agregarPublicacion("descPubli");
            Publicacion p =publicacionRepository.findById(1);
            sistemaServices.agregarComentario(p, "");
            fail("Dejo guardar sin descripcion ");

        } catch (Exception e) {
            // OK
        }
    }

    // ==

}
