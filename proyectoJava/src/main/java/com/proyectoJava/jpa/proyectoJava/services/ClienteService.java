package com.proyectoJava.jpa.proyectoJava.services;

import com.proyectoJava.jpa.proyectoJava.dto.ClienteDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.ClienteMapper;
import com.proyectoJava.jpa.proyectoJava.model.Cliente;
import com.proyectoJava.jpa.proyectoJava.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final RestTemplate restTemplate;
    private final String apiUrl = "https://jsonplaceholder.typicode.com/users";

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper, RestTemplate restTemplate) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
        this.restTemplate = restTemplate;
    }

    public List<ClienteDTO> obtenerClientesDesdeAPI() {
        ClienteDTO[] clientesApi = restTemplate.getForObject(apiUrl, ClienteDTO[].class);
        List<Cliente> clientes = List.of(clientesApi).stream()
                                      .map(clienteMapper::toEntity)
                                      .collect(Collectors.toList());
        clienteRepository.saveAll(clientes); // Guarda en base de datos local
        return clientes.stream()
                       .map(clienteMapper::toDTO)
                       .collect(Collectors.toList());
    }
    
    public ClienteDTO obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDTO)
                .orElse(null);
    }
}