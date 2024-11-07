package com.proyectoJava.jpa.proyectoJava.repository;

import com.proyectoJava.jpa.proyectoJava.model.Autor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    public Optional<Autor> findByNombreAndApellido(String nombre, String apellido);

}
