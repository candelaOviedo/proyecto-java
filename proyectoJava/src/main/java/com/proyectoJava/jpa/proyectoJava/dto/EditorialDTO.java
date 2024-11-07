package com.proyectoJava.jpa.proyectoJava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorialDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private Long telefono;
    private String email;

}