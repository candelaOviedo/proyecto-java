package com.proyectoJava.jpa.proyectoJava.mapper;

import com.proyectoJava.jpa.proyectoJava.dto.LibroDTO;
import com.proyectoJava.jpa.proyectoJava.model.Autor;
import com.proyectoJava.jpa.proyectoJava.model.Editorial;
import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.services.AutorService;
import com.proyectoJava.jpa.proyectoJava.services.EditorialService;

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

    public static Libro toEntity(LibroDTO dto, AutorService autorService, EditorialService editorialService) {
        Libro libro = new Libro();
        libro.setId(dto.getId());
        libro.setTitulo(dto.getTitulo());

        // Buscar el autor por nombre y apellido
        if (dto.getAutorNombre() != null && dto.getAutorApellido() != null) {
            Autor autor = autorService.findByNombreAndApellido(dto.getAutorNombre(), dto.getAutorApellido());
            libro.setAutor(autor);
        }

        // Buscar la editorial por nombre
        if (dto.getEditorialNombre() != null) {
            Editorial editorial = editorialService.findByNombre(dto.getEditorialNombre());
            libro.setEditorial(editorial);
        }

        libro.setPublicacion(dto.getPublicacion());
        libro.setGenero(dto.getGenero());
        libro.setPrecio(dto.getPrecio());

        return libro;
    }
}