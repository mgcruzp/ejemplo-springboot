package com.jorgito.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jorgito.demo.modelo.Comunidad;
import com.jorgito.demo.repositorio.ComunidadRepository;

import jakarta.transaction.Transactional;

@Component
public class InicializadorBaseDatos implements CommandLineRunner {

    @Autowired
    ComunidadRepository comunidades;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        
        // inicializa las comunidades
        try {
            
/*
            Comunidad comunidad = new Comunidad();
            comunidad.setNombre("La comunidad");
            comunidades.save(comunidad);

            comunidad = new Comunidad();
            comunidad.setNombre("Los otros");
            comunidades.save(comunidad);

            comunidad = new Comunidad();
            comunidad.setNombre("Los duros");
            comunidades.save(comunidad);
*/

        } catch (Exception e) {
            System.out.println("No funcionó !!");
        }

    }

}
