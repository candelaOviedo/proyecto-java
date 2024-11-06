package com.proyectoJava.jpa.proyectoJava.mapper;

import com.proyectoJava.jpa.proyectoJava.dto.CompraDTO;
import com.proyectoJava.jpa.proyectoJava.model.Compra;
import com.proyectoJava.jpa.proyectoJava.model.Cliente;
import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompraMapper {

    @Autowired
    private LibroRepository libroRepository;

    // Convierte de entidad Compra a DTO
    public CompraDTO toDTO(Compra compra) {
        CompraDTO dto = new CompraDTO();
        dto.setId(compra.getId());
        dto.setClienteId(compra.getCliente().getId());
        dto.setLibroIds(compra.getLibros().stream().map(Libro::getId).collect(Collectors.toList()));
        dto.setFecha(compra.getFecha());
        dto.setTotal(compra.getTotal());
        return dto;
    }

    // Convierte de DTO a entidad Compra
    public Compra toEntity(CompraDTO dto) {
        Compra compra = new Compra();
        Cliente cliente = new Cliente();
        cliente.setId(dto.getClienteId());
        compra.setCliente(cliente);

        // Buscar los libros por ID utilizando el repositorio
        List<Libro> libros = dto.getLibroIds().stream()
                                    .map(id -> libroRepository.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado: " + id)))
                                    .collect(Collectors.toList());
        compra.setLibros(libros);

        compra.setFecha(dto.getFecha());
        compra.setTotal(dto.getTotal());

        return compra;
    }
}