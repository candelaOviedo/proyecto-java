package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.CompraDTO;
import com.proyectoJava.jpa.proyectoJava.services.CompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @Operation(summary = "Realizar una compra de libros", description = "Este método permite realizar una compra de libros por parte de un cliente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Compra realizada con éxito"),
        @ApiResponse(responseCode = "400", description = "Error al realizar la compra, libros no encontrados o problemas de validación")
    })
    @PostMapping
    public ResponseEntity<CompraDTO> realizarCompra(@RequestBody @Parameter(description = "Datos de la compra que se desea realizar") CompraDTO compraDTO) {
        try {
            CompraDTO compraRealizada = compraService.realizarCompra(compraDTO);
            return new ResponseEntity<>(compraRealizada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}