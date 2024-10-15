package com.proyectoJava.jpa.proyectoJava.services;

import java.util.List;

import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.repository.LibroRepository;
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

public void creandoLibro (Libro l){
    this.libroRepository.save (l);
}

}
