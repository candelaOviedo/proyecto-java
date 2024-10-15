package com.proyectoJava.jpa.proyectoJava.services;

import com.proyectoJava.jpa.proyectoJava.model.Editorial;
import com.proyectoJava.jpa.proyectoJava.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EditorialService {

    private EditorialRepository editorialRepository;

    @Autowired
    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public List<Editorial> getAllEditoriales() {
        return editorialRepository.findAll();
    }

    public void agregarEditorial(Editorial editorial) {
        Editorial e = this.editorialRepository.findByNombre(editorial.getNombre());
        if (e != null) {
            throw new IllegalArgumentException("La editorial ya existe");
        }
        this.editorialRepository.save(editorial);
    }


}