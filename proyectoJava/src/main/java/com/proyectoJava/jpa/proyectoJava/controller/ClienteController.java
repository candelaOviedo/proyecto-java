package com.proyectoJava.jpa.proyectoJava.controller;

import com.proyectoJava.jpa.proyectoJava.dto.ClienteDTO;
import com.proyectoJava.jpa.proyectoJava.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Obtener todos los clientes desde la API
    @GetMapping
    @Operation(summary = "Obtener todos los clientes", description = "Llama a la API externa para obtener los datos de los clientes.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clientes obtenidos correctamente"),
        @ApiResponse(responseCode = "500", description = "Error al obtener clientes desde la API externa")
    })
    public List<ClienteDTO> obtenerClientesDesdeAPI() {
        return clienteService.obtenerClientesDesdeAPI();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un cliente por su ID", description = "Retorna los detalles del cliente según el ID proporcionado.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    public ClienteDTO obtenerClientePorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    // Crear un nuevo cliente
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear un nuevo cliente", description = "Permite crear un nuevo cliente en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Cliente creado correctamente")
    public ClienteDTO crear(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.crear(clienteDTO);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un cliente", description = "Actualiza los datos de un cliente existente con los datos proporcionados.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    public ClienteDTO actualizar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        return clienteService.actualizar(id, clienteDTO);
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar un cliente por ID", description = "Elimina un cliente de la base de datos según su ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Cliente eliminado correctamente"),
        @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}