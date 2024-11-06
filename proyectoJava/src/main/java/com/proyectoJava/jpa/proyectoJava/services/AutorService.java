package com.proyectoJava.jpa.proyectoJava.services;

import com.proyectoJava.jpa.proyectoJava.dto.AutorDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.AutorMapper;
import com.proyectoJava.jpa.proyectoJava.model.Autor;
import com.proyectoJava.jpa.proyectoJava.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AutorMapper autorMapper;

    // Obtener todos los autores
    public List<AutorDTO> obtenerTodos() {
        List<Autor> autores = autorRepository.findAll();
        return autores.stream()
                .map(autorMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Obtener un autor por ID
    public AutorDTO obtenerPorId(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return autorMapper.toDTO(autor.get());
        }
        throw new RuntimeException("Autor no encontrado");
    }

    // Crear o actualizar un autor
    public AutorDTO crearOActualizar(AutorDTO autorDTO) {
        Autor autor = autorMapper.toEntity(autorDTO);
        autor = autorRepository.save(autor);
        return autorMapper.toDTO(autor);
    }

    // Eliminar un autor
    public void eliminar(Long id) {
        autorRepository.deleteById(id);
    }
}