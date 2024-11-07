package com.proyectoJava.jpa.proyectoJava.services;

import com.proyectoJava.jpa.proyectoJava.dto.EditorialDTO;
import com.proyectoJava.jpa.proyectoJava.mapper.EditorialMapper;
import com.proyectoJava.jpa.proyectoJava.model.Editorial;
import com.proyectoJava.jpa.proyectoJava.repository.EditorialRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private EditorialMapper editorialMapper;

    // Crea una nueva editorial
    public EditorialDTO crear(EditorialDTO editorialDTO) {
        Editorial editorial = editorialMapper.toEntity(editorialDTO);
        editorial = editorialRepository.save(editorial);
        return editorialMapper.toDTO(editorial);
    }

    // Actualiza una editorial existente
    public EditorialDTO actualizar(Long id, EditorialDTO editorialDTO) {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        // Actualiza los datos de la editorial con los datos del DTO
        editorial.setNombre(editorialDTO.getNombre());
        editorial.setDireccion(editorialDTO.getDireccion());
        editorial.setTelefono(editorialDTO.getTelefono());
        editorial.setEmail(editorialDTO.getEmail());

        editorial = editorialRepository.save(editorial);
        return editorialMapper.toDTO(editorial);
    }

    // Obtiene una editorial por su ID
    public EditorialDTO obtenerPorId(Long id) {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));
        return editorialMapper.toDTO(editorial);
    }

    // Elimina una editorial por su ID
    public void eliminar(Long id) {
        editorialRepository.deleteById(id);
    }

        // Buscar editorial por nombre
        public Editorial findByNombre(String nombre) {
            Optional<Editorial> editorial = editorialRepository.findByNombre(nombre);
            if (editorial.isPresent()) {
                return editorial.get();
            }
            throw new RuntimeException("Editorial no encontrada");
        }
}