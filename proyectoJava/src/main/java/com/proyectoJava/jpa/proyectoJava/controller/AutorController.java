package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.AutorDTO;
import com.proyectoJava.jpa.proyectoJava.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Obtener todos los autores
    @GetMapping
    public List<AutorDTO> obtenerTodos() {
        return autorService.obtenerTodos();
    }

    // Obtener un autor por ID
    @GetMapping("/{id}")
    public AutorDTO obtenerPorId(@PathVariable Long id) {
        return autorService.obtenerPorId(id);
    }

    // Crear o actualizar un autor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutorDTO crearOActualizar(@RequestBody AutorDTO autorDTO) {
        return autorService.crearOActualizar(autorDTO);
    }

    // Eliminar un autor
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        autorService.eliminar(id);
    }
}