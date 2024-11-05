package com.jorgito.demo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    // Buscar por email, sin uso de Optional
    Usuario findByEmail(String email);

    // Verificar si existe un usuario por email
    boolean existsByEmail(String email);

    // Verificar si existe un usuario por teléfono
    boolean existsByTeléfono(int teléfono);
}

