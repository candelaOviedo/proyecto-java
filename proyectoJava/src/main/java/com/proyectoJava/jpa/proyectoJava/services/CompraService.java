package com.proyectoJava.jpa.proyectoJava.services;


import com.proyectoJava.jpa.proyectoJava.dto.CompraDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.CompraMapper;
import com.proyectoJava.jpa.proyectoJava.model.Compra;
import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.repository.CompraRepository;
import com.proyectoJava.jpa.proyectoJava.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CompraMapper compraMapper;

    // Realiza la compra
    public CompraDTO realizarCompra(CompraDTO compraDTO) {
        List<Libro> libros = libroRepository.findAllById(compraDTO.getLibroIds());
        if (libros.isEmpty()) {
            throw new RuntimeException("Libros no encontrados");
        }

        // Calcular el total
        double total = libros.stream().mapToDouble(Libro::getPrecio).sum();

        // Crear la entidad Compra
        Compra compra = compraMapper.toEntity(compraDTO);
        compra.setLibros(libros);
        compra.setFecha(LocalDate.now());
        compra.setTotal(total);

        // Guardar la compra
        Compra compraGuardada = compraRepository.save(compra);

        // Reducir el stock de los libros
        for (Libro libro : libros) {
            libro.setStock(libro.getStock() - 1);
            libroRepository.save(libro);
        }

        return compraMapper.toDTO(compraGuardada);
    }
}
