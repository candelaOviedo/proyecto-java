package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.CompraDTO;
import com.proyectoJava.jpa.proyectoJava.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<CompraDTO> realizarCompra(@RequestBody CompraDTO compraDTO) {
        try {
            CompraDTO compraRealizada = compraService.realizarCompra(compraDTO);
            return new ResponseEntity<>(compraRealizada, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}