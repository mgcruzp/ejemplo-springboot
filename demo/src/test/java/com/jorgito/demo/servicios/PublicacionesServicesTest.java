package com.jorgito.demo.servicios;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jorgito.demo.repositorio.ComunidadRepository;
import com.jorgito.demo.repositorio.PublicacionRepository;
import com.jorgito.demo.repositorio.UsuarioRepository;

@SpringBootTest
public class PublicacionesServicesTest {

    @Autowired
    PublicacionRepository publicacionRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ComunidadRepository comunidadRepository;

    @Autowired
    SistemaServices sistemaServices;

    
    @BeforeEach
    public void borrarUsuarios()  {
        usuarioRepository.deleteAll();
        comunidadRepository.deleteAll();
        publicacionRepository.deleteAll();
    }

    @Test
    void PublicarSinError() {
        try {
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            sistemaServices.crearComunidad("nombre" ,"desc");
            sistemaServices.agregarPublicacion("desc Publi");
            // ok
        } catch (Exception e) {
            fail("no dejo grabar con todos los datos bien", e);
        }
    }

}
