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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    // Obtener todos los clientes desde la API externa
    public List<ClienteDTO> obtenerClientesDesdeAPI() {
        RestTemplate restTemplate = new RestTemplate();
        Cliente[] clientesArray = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", Cliente[].class);

        return List.of(clientesArray).stream()
        .map(clienteMapper::toDTO)
        .collect(Collectors.toList());
    }

    // Obtener un cliente por ID
    public ClienteDTO obtenerClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return clienteMapper.toDTO(cliente);
    }
    // Crear un nuevo cliente
    public ClienteDTO crear(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);  
        return clienteMapper.toDTO(cliente);
    }

    // Actualizar un cliente existente
    public ClienteDTO actualizar(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));


        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setEmail(clienteDTO.getEmail());

        cliente = clienteRepository.save(cliente); 
        return clienteMapper.toDTO(cliente);
    }

    // Eliminar un cliente por ID
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}