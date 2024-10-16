package com.proyectoJava.jpa.proyectoJava.services;

import java.util.List;

import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.repository.LibroRepository;

import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LibroService {

@Autowired
private LibroRepository libroRepository;


public LibroService(LibroRepository libroRepository) {
    this.libroRepository = libroRepository;
}


// para que devuelva lista de libros:
public List<Libro> getAllLibros() {
    return libroRepository.findAll();
}

//buscar libro por titulo
public List<Libro> getLibroByTitulo (String titulo) {
return this.libroRepository.findByTitulo(titulo);
}

public void agregarLibro (Libro libro){
    List<Libro> l = this.libroRepository.findByTitulo (libro.getTitulo());
    if (l != null) {
        throw new IllegalIdentifierException("El libro ya existe");
    }
    this.libroRepository.save (libro);
}

    // Eliminar un libro por su ID
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

}
