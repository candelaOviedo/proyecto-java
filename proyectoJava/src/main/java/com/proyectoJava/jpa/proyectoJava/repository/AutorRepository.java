package com.proyectoJava.jpa.proyectoJava.repository;

import com.proyectoJava.jpa.proyectoJava.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {


}
