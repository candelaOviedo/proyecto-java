package com.proyectoJava.jpa.proyectoJava.repository;

import com.proyectoJava.jpa.proyectoJava.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}