package com.proyectoJava.jpa.proyectoJava.services;

import com.proyectoJava.jpa.proyectoJava.dto.EditorialDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.EditorialMapper;
import com.proyectoJava.jpa.proyectoJava.model.Editorial;
import com.proyectoJava.jpa.proyectoJava.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private EditorialMapper editorialMapper;

    // Crea o actualiza una editorial
    public EditorialDTO crearOActualizar(EditorialDTO editorialDTO) {
        Editorial editorial = editorialMapper.toEntity(editorialDTO);
        editorial = editorialRepository.save(editorial);  // Save maneja crear o actualizar
        return editorialMapper.toDTO(editorial);
    }

    // Obtiene una editorial por su ID
    public EditorialDTO obtenerPorId(Long id) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
        return editorialMapper.toDTO(editorial);
    }

    // Elimina una editorial por su ID
    public void eliminar(Long id) {
        editorialRepository.deleteById(id);
    }
}