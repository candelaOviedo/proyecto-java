package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.EditorialDTO;
import com.proyectoJava.jpa.proyectoJava.services.EditorialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    // Crea una nueva editorial
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear una nueva editorial", description = "Permite crear una nueva editorial en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Editorial creada correctamente")
    public EditorialDTO crear(@RequestBody EditorialDTO editorialDTO) {
        return editorialService.crear(editorialDTO);
    }

    // Actualiza una editorial existente
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una editorial", description = "Actualiza los datos de una editorial existente con los datos proporcionados.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Editorial actualizada correctamente"),
        @ApiResponse(responseCode = "404", description = "Editorial no encontrada")
    })
    public EditorialDTO actualizar(@PathVariable Long id, @RequestBody EditorialDTO editorialDTO) {
        editorialDTO.setId(id);
        return editorialService.actualizar(id, editorialDTO);
    }

    // Obtiene una editorial por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una editorial por ID", description = "Retorna los detalles de una editorial según el ID proporcionado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Editorial encontrada"),
        @ApiResponse(responseCode = "404", description = "Editorial no encontrada")
    })
    public EditorialDTO obtenerPorId(@PathVariable Long id) {
        return editorialService.obtenerPorId(id);
    }

    // Elimina una editorial por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar una editorial por ID", description = "Elimina una editorial de la base de datos según su ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Editorial eliminada correctamente"),
        @ApiResponse(responseCode = "404", description = "Editorial no encontrada")
    })
    public void eliminar(@PathVariable Long id) {
        editorialService.eliminar(id);
    }
}