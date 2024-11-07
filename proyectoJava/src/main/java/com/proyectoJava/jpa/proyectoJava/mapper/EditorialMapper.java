package com.proyectoJava.jpa.proyectoJava.mapper;

import com.proyectoJava.jpa.proyectoJava.dto.EditorialDTO;
import com.proyectoJava.jpa.proyectoJava.model.Editorial;
import org.springframework.stereotype.Component;

@Component
public class EditorialMapper {

    public EditorialDTO toDTO(Editorial editorial) {
        EditorialDTO dto = new EditorialDTO();
        dto.setId(editorial.getId());
        dto.setNombre(editorial.getNombre());
        dto.setDireccion(editorial.getDireccion());
        dto.setTelefono(editorial.getTelefono());
        dto.setEmail(editorial.getEmail());
        return dto;
    }

    public Editorial toEntity(EditorialDTO dto) {
        Editorial editorial = new Editorial();
        editorial.setId(dto.getId());
        editorial.setNombre(dto.getNombre());
        editorial.setDireccion(dto.getDireccion());
        editorial.setTelefono(dto.getTelefono());
        editorial.setEmail(dto.getEmail());
        return editorial;
    }
}