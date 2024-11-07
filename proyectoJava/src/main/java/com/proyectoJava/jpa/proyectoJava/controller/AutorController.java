package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.AutorDTO;
import com.proyectoJava.jpa.proyectoJava.services.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Obtener todos los autores
    @GetMapping
    @Operation(summary = "Obtener todos los autores", description = "Retorna la lista de todos los autores registrados.")
    @ApiResponse(responseCode = "200", description = "Autores encontrados")
    public List<AutorDTO> obtenerTodos() {
        return autorService.obtenerTodos();
    }

    // Obtener un autor por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un autor por ID", description = "Retorna los detalles de un autor según el ID proporcionado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Autor encontrado"),
        @ApiResponse(responseCode = "404", description = "Autor no encontrado")
    })
    public AutorDTO obtenerPorId(@PathVariable Long id) {
        return autorService.obtenerPorId(id);
    }

    // Crear o actualizar un autor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear o actualizar un autor", description = "Crea un nuevo autor o actualiza un autor existente.")
    @ApiResponse(responseCode = "201", description = "Autor creado o actualizado correctamente")
    public AutorDTO crearOActualizar(@RequestBody AutorDTO autorDTO) {
        return autorService.crearOActualizar(autorDTO);
    }

    // Eliminar un autor
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar un autor", description = "Elimina un autor de la base de datos según su ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Autor eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Autor no encontrado")
    })
    public void eliminar(@PathVariable Long id) {
        autorService.eliminar(id);
    }
}