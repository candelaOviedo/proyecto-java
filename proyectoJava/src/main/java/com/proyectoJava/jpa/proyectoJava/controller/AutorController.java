package com.proyectoJava.jpa.proyectoJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoJava.jpa.proyectoJava.model.Autor;
import com.proyectoJava.jpa.proyectoJava.repository.AutorRepository;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/create")
    public ResponseEntity<?> agregarAutor(@RequestBody Autor autor) {
        try {
            autorRepository.save(autor);
            return ResponseEntity.ok(autor);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear el autor");
        }
    }

}
