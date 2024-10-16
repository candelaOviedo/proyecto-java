package com.proyectoJava.jpa.proyectoJava.dto;

import java.io.Serializable;

public class LibroDTO implements Serializable {

    private Long id;

    private String titulo;

    private String autor;

    private String editorial;

    private String publicacion;

    private String genero;

    private Double precio;

    public LibroDTO(String titulo, String autor, String editorial, String publicacion, String genero, Double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.publicacion = publicacion;
        this.genero = genero;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
