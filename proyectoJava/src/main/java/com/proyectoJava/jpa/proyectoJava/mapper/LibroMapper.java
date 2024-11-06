package com.proyectoJava.jpa.proyectoJava.mapper;

import com.proyectoJava.jpa.proyectoJava.dto.LibroDTO;
import com.proyectoJava.jpa.proyectoJava.model.Libro;

public class LibroMapper {

    public static LibroDTO toDTO(Libro libro) {
        LibroDTO dto = new LibroDTO();
        dto.setId(libro.getId());
        dto.setTitulo(libro.getTitulo());
        dto.setAutorNombre(libro.getAutor().getNombre());
        dto.setAutorApellido(libro.getAutor().getApellido());
        dto.setEditorialNombre(libro.getEditorial().getNombre());
        dto.setPublicacion(libro.getPublicacion());
        dto.setGenero(libro.getGenero());
        dto.setPrecio(libro.getPrecio());
        return dto;
    }

    public static Libro toEntity(LibroDTO dto) {
        Libro libro = new Libro();
        libro.setId(dto.getId());
        libro.setTitulo(dto.getTitulo());
        // Aquí debes cargar los objetos `Autor` y `Editorial` según el contexto.
        return libro;
    }
}