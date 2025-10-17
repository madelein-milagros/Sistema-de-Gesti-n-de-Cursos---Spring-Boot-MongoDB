package com.example.prj_crud_spring_boot_mongodb.service;

import com.example.prj_crud_spring_boot_mongodb.model.Curso;
import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> getAllCursos();
    Optional<Curso> getCursoById(String id);
    Curso createCurso(Curso curso);
    Curso updateCurso(String id, Curso curso);
    void deleteCurso(String id);
    List<Curso> searchByNombre(String nombre);
    List<Curso> searchByDocente(String docente);
}