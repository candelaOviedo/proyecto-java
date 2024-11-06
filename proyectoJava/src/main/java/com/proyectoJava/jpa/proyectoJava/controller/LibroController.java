package com.proyectoJava.jpa.proyectoJava.controller;

import java.util.List;

import com.proyectoJava.jpa.proyectoJava.dto.LibroDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.LibroMapper;
import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.services.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Devuelve todos los libros
    @GetMapping("/all")
    public List<LibroDTO> getAllLibros() {
        return this.libroService.getAllLibros();
    }

    // Buscar libro por título
    @GetMapping("/titulo")
    public ResponseEntity<?> getLibroByTitulo(@RequestParam String titulo) {
        try {
            List<LibroDTO> libros = this.libroService.getLibroByTitulo(titulo);
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Crear libro
    @PostMapping("/create")
    public ResponseEntity<?> agregarLibro(@RequestBody LibroDTO libroDTO) {
        try {
            // Aquí deberías mapear el DTO a la entidad Libro
            Libro libro = LibroMapper.toEntity(libroDTO);
            this.libroService.agregarLibro(libro);
            return ResponseEntity.ok(libroDTO);
        } catch (Exception e) {
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