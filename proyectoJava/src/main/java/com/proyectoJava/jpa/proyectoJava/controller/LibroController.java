package com.proyectoJava.jpa.proyectoJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.services.LibroService;

@RestController
@RequestMapping ("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    //devuelve todos los libros
    @GetMapping("/all")
    public List <Libro> getAllLibros() {
        return this.libroService.getAllLibros();
    }

    //crear libro
    @PostMapping ("/create")
    public ResponseEntity<?> agregarLibro (@RequestBody Libro libro){
        this.libroService.creandoLibro(libro);
        return new ResponseEntity<>("CREATED", HttpStatus.CREATED);
    }

}
