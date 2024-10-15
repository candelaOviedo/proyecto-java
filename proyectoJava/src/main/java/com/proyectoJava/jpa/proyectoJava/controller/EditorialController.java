package com.proyectoJava.jpa.proyectoJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoJava.jpa.proyectoJava.model.Editorial;
import com.proyectoJava.jpa.proyectoJava.services.EditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    // Devuelve todas las editoriales
    @GetMapping("/all")
    public List<Editorial> getAllEditoriales() {
        return editorialService.getAllEditoriales();
    }

    // Crear una nueva editorial
    @PostMapping("/create")
    public ResponseEntity<?> agregarEditorial(@RequestBody Editorial editorial) {
        try {
            editorialService.agregarEditorial(editorial);
            return ResponseEntity.ok(editorial);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }
}