package com.proyectoJava.jpa.proyectoJava.services;

import com.proyectoJava.jpa.proyectoJava.model.Autor;
import com.proyectoJava.jpa.proyectoJava.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

}