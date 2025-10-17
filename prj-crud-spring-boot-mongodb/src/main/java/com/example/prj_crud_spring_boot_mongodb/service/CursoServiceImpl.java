package com.example.prj_crud_spring_boot_mongodb.service;


import com.example.prj_crud_spring_boot_mongodb.model.Curso;
import com.example.prj_crud_spring_boot_mongodb.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> getCursoById(String id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso createCurso(Curso curso) {
        System.out.println("DEBUG: Guardando nuevo curso: " + curso);
        Curso savedCurso = cursoRepository.save(curso);
        System.out.println("DEBUG: Curso guardado con ID: " + savedCurso.getId());
        return savedCurso;
    }

    @Override
    public Curso updateCurso(String id, Curso cursoDetails) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            Curso curso = optionalCurso.get();
            curso.setNombre(cursoDetails.getNombre());
            curso.setCreditos(cursoDetails.getCreditos());
            curso.setDocente(cursoDetails.getDocente());
            curso.setHoras(cursoDetails.getHoras());
            return cursoRepository.save(curso);
        }
        return null;
    }

    @Override
    public void deleteCurso(String id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Curso> searchByNombre(String nombre) {
        return cursoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Curso> searchByDocente(String docente) {
        return cursoRepository.findByDocenteContainingIgnoreCase(docente);
    }
}