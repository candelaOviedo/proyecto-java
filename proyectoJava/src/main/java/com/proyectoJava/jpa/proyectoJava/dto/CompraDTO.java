package com.proyectoJava.jpa.proyectoJava.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class CompraDTO {

    private Long id;
    private Long clienteId;
    private List<Long> libroIds;
    private LocalDate fecha;
    private double total;
}