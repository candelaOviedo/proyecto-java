package com.proyectoJava.jpa.proyectoJava.repository;

import com.proyectoJava.jpa.proyectoJava.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

}
