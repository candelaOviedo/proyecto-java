package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.ClienteDTO;
import com.proyectoJava.jpa.proyectoJava.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/api")
    public List<ClienteDTO> obtenerClientesDesdeAPI() {
        return clienteService.obtenerClientesDesdeAPI();
    }

    @GetMapping("/{id}")
    public ClienteDTO obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }
}