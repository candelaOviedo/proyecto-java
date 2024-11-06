package com.proyectoJava.jpa.proyectoJava.repository;

import com.proyectoJava.jpa.proyectoJava.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
}