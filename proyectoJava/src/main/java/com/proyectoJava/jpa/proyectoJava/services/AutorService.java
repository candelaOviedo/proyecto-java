package com.proyectoJava.jpa.proyectoJava.services;

import com.proyectoJava.jpa.proyectoJava.model.Autor;
import com.proyectoJava.jpa.proyectoJava.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


   // Obtener todos los autores
    public List<Autor> getAllAutores() {
    return autorRepository.findAll();
}

// Agregar un nuevo autor
public void agregarAutor(Autor autor) {
    Autor a = this.autorRepository.findByApellido(autor.getApellido());
    if (a != null) {
        throw new IllegalArgumentException("El autor con este apellido ya existe");
    }
    this.autorRepository.save(autor);
}


}