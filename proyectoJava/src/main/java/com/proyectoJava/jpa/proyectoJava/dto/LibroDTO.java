package com.proyectoJava.jpa.proyectoJava.dto;

import com.proyectoJava.jpa.proyectoJava.model.GeneroLiterario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {

    private Long id;
    private String titulo;
    private String autorNombre;
    private String autorApellido;
    private String editorialNombre;
    private int publicacion;
    private GeneroLiterario genero;
    private double precio;

}