package com.proyectoJava.jpa.proyectoJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoJava.jpa.proyectoJava.model.Autor;
import com.proyectoJava.jpa.proyectoJava.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Devuelve todos los autores
    @GetMapping("/all")
    public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }


    // Crear un nuevo autor
    @PostMapping("/create")
    public ResponseEntity<?> agregarAutor(@RequestBody Autor autor) {
        try {
            autorService.agregarAutor(autor);
            return ResponseEntity.ok(autor);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }

}
