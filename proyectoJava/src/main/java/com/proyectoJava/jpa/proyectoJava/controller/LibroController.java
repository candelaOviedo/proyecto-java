package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.LibroDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.LibroMapper;
import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.services.AutorService;
import com.proyectoJava.jpa.proyectoJava.services.EditorialService;
import com.proyectoJava.jpa.proyectoJava.services.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditorialService editorialService;


    //Obtener todos los libros
    @Operation(summary = "Obtener todos los libros", description = "Devuelve una lista de todos los libros disponibles en la base de datos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Libros encontrados"),
        @ApiResponse(responseCode = "500", description = "Error en la consulta")
    })
    @GetMapping("/all")
    public List<LibroDTO> getAllLibros() {
        return this.libroService.getAllLibros();
    }


    //Buscar libro por titulo
    @Operation(summary = "Buscar libro por título", description = "Busca un libro utilizando su título.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Libros encontrados"),
        @ApiResponse(responseCode = "400", description = "Error en la búsqueda")
    })
    @GetMapping("/titulo")
    public ResponseEntity<?> getLibroByTitulo(@RequestParam String titulo) {
        try {
            List<LibroDTO> libros = this.libroService.getLibroByTitulo(titulo);
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    //Crear libro
    @Operation(summary = "Crear un libro", description = "Crea un nuevo libro en la base de datos.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Libro creado correctamente"),
        @ApiResponse(responseCode = "400", description = "Error al crear el libro")
    })
    @PostMapping("/create")
    public ResponseEntity<?> agregarLibro(@RequestBody LibroDTO libroDTO) {
        try {
            Libro libro = LibroMapper.toEntity(libroDTO, autorService, editorialService);
            this.libroService.agregarLibro(libro);
            return ResponseEntity.ok(libroDTO);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }


    //Eliminar un libro por ID
    @Operation(summary = "Eliminar un libro", description = "Elimina un libro de la base de datos usando su ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Libro eliminado correctamente"),
        @ApiResponse(responseCode = "400", description = "Error al eliminar el libro")
    })
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