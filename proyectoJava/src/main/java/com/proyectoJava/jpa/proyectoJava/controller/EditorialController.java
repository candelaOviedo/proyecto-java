package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.EditorialDTO;
import com.proyectoJava.jpa.proyectoJava.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    // Crea o actualiza una editorial
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EditorialDTO crearOActualizar(@RequestBody EditorialDTO editorialDTO) {
        return editorialService.crearOActualizar(editorialDTO);
    }

    // Obtiene una editorial por ID
    @GetMapping("/{id}")
    public EditorialDTO obtenerPorId(@PathVariable Long id) {
        return editorialService.obtenerPorId(id);
    }

    // Elimina una editorial por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        editorialService.eliminar(id);
    }
}