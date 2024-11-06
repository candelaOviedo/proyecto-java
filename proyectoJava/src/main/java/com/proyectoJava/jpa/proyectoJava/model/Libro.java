package com.proyectoJava.jpa.proyectoJava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Libro {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editorial_id", nullable = false)
    private Editorial editorial;

    private int publicacion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroLiterario genero;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock;


            public Libro(String titulo, Autor autor, Editorial editorial, int publicacion, GeneroLiterario genero,
                double precio, int stock) {
            this.titulo = titulo;
            this.autor = autor;
            this.editorial = editorial;
            this.publicacion = publicacion;
            this.genero = genero;
            this.precio = precio;
            this.stock = stock;
        }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        return true;
        if (obj == null)
        return false;
        if (getClass() != obj.getClass())
        return false;
        Libro other = (Libro) obj;
        if (id == null) {
            if (other.id != null)
            return false;
        } else if (!id.equals(other.id))
        return false;
        if (titulo == null) {
            if (other.titulo != null)
            return false;
        } else if (!titulo.equals(other.titulo))
        return false;
        if (autor == null) {
            if (other.autor != null)
            return false;
        } else if (!autor.equals(other.autor))
        return false;
        if (editorial == null) {
            if (other.editorial != null)
            return false;
        } else if (!editorial.equals(other.editorial))
        return false;
        return true;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((editorial == null) ? 0 : editorial.hashCode());
        return result;
    }




        @Override
        public String toString() {
            return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial
                    + ", publicacion=" + publicacion + ", genero=" + genero + ", precio=" + precio + "]";
        }



}
