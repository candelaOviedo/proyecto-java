package com.proyectoJava.jpa.proyectoJava.mapper;

import com.proyectoJava.jpa.proyectoJava.dto.AutorDTO;
import com.proyectoJava.jpa.proyectoJava.model.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    // Convierte de entidad Autor a DTO
    public AutorDTO toDTO(Autor autor) {
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autor.getId());
        autorDTO.setNombre(autor.getNombre());
        autorDTO.setApellido(autor.getApellido());
        autorDTO.setNacionalidad(autor.getNacionalidad());
        autorDTO.setFechaNacimiento(autor.getFechaNacimiento());
        return autorDTO;
    }

    // Convierte de DTO a entidad Autor
    public Autor toEntity(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setId(autorDTO.getId());
        autor.setNombre(autorDTO.getNombre());
        autor.setApellido(autorDTO.getApellido());
        autor.setNacionalidad(autorDTO.getNacionalidad());
        autor.setFechaNacimiento(autorDTO.getFechaNacimiento());
        return autor;
    }
}
