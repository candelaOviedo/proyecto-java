package com.proyectoJava.jpa.proyectoJava.services;

import java.util.List;
import java.util.stream.Collectors;

import com.proyectoJava.jpa.proyectoJava.dto.LibroDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.LibroMapper;
import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Obtener todos los libros
    public List<LibroDTO> getAllLibros() {
        List<Libro> libros = libroRepository.findAll();
        return libros.stream()
                        .map(LibroMapper::toDTO)
                        .collect(Collectors.toList());
    }

    // Buscar libro por título
    public List<LibroDTO> getLibroByTitulo(String titulo) {
        List<Libro> libros = libroRepository.findByTitulo(titulo);
        return libros.stream()
                        .map(LibroMapper::toDTO)
                        .collect(Collectors.toList());
    }

    // Agregar un libro
    public void agregarLibro(Libro libro) {
        List<Libro> l = this.libroRepository.findByTitulo(libro.getTitulo());
        if (l != null) {
            throw new IllegalStateException("El libro ya existe");
        }
        this.libroRepository.save(libro);
    }

    // Eliminar un libro
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}