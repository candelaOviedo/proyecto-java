package com.proyectoJava.jpa.proyectoJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //buscar libro por titulo
    @GetMapping ("/titulo")
    public ResponseEntity<?> getLibroByTitulo (@RequestParam String titulo) {
    try {
        this.libroService.getLibroByTitulo(titulo);
        return ResponseEntity.ok(this.libroService.getLibroByTitulo(titulo));
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    }


    //crear libro
    @PostMapping ("/create")
    public ResponseEntity<?> agregarLibro (@RequestBody Libro libro){
        try {
        this.libroService.agregarLibro(libro);
        return ResponseEntity.ok(libro);
        } catch (Exception e) {
        System.out.println( "Error: " + e.getMessage());
        return ResponseEntity.status(400).body(e.getMessage());
        }
    }

        // Eliminar un libro por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarLibro(@PathVariable Long id) {
        try {
            libroService.eliminarLibro(id);
            return ResponseEntity.ok("Libro con ID " + id + " eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: " + e.getMessage());
        }
    }

}
