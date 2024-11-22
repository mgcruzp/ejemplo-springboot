package com.jorgito.demo.servicios;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import com.jorgito.demo.repositorio.ComunidadRepository;
import com.jorgito.demo.repositorio.UsuarioRepository;

@SpringBootTest
public class ComunidadServicesTest {

    @Autowired
    SistemaServices sistemaServices;


    @Autowired
    ComunidadRepository comunidadRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @BeforeEach
    public void borrarUsuarios()  {
        usuarioRepository.deleteAll();
        comunidadRepository.deleteAll();
        
    }


    @Test
    public void crearComunidadSinDescripcion() {
        try {
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            sistemaServices.crearComunidad("otro@ejemplo.com", "");
            fail("Dejo guardar sin descripcion");

        } catch (Exception e) {
            // OK
        }
    }
    @Test
    public void entrarAComunidadConErrorEnNombreDeComunidad() {
        try {
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            sistemaServices.crearComunidad("otro@ejemplo.com", "dea");
            sistemaServices.entrarAComunidad("fakeName");
            fail("Dejo guardar con error en el nombre de la comunidad");

        } catch (Exception e) {
            // OK
        }
    }

    @Test
    public void crearComunidadSinNombre() {
        try {
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            sistemaServices.crearComunidad("", "dea");
            fail("Dejo crear Comunidad Sin Nombre");

        } catch (Exception e) {
            // OK
        }
    }

    @Test
    public void crearComunidadSinProblemas() {
        try {
            sistemaServices.registrarse("jaime", 20, "jaime@ejemplo.com", "secret");
            sistemaServices.crearComunidad("deassa", "dea");
             // OK
            
        } catch (Exception e) {
            fail("salio excepcion",e);
            
        }
    }
    
    
}
