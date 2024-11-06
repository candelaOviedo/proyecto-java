package com.proyectoJava.jpa.proyectoJava.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "compra")
@Data
@NoArgsConstructor
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
      name = "compra_libro",
      joinColumns = @JoinColumn(name = "compra_id"),
      inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libros;

    private LocalDate fecha;
    private double total;
}