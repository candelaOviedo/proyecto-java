package com.proyectoJava.jpa.proyectoJava.repository;


import com.proyectoJava.jpa.proyectoJava.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {



}
