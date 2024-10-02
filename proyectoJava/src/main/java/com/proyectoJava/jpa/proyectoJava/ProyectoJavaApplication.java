package com.proyectoJava.jpa.proyectoJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyectoJava.jpa.proyectoJava.model.Libro;
import com.proyectoJava.jpa.proyectoJava.services.LibroService;

@SpringBootApplication
public class ProyectoJavaApplication implements CommandLineRunner {

	@Autowired
	LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoJavaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		//Devuelve lista de libros (LibroService):
		for (Libro li : libroService.getAllLibros()) {
			System.out.println(li);
		}


	}

}
