package com.jorgito.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgito.demo.modelo.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
