package com.proyectoJava.jpa.proyectoJava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {

    private Long id;
    private Long clienteId;
    private List<Long> libroIds;
    private LocalDate fecha;
    private double total;
}