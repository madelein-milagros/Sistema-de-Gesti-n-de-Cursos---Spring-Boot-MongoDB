package com.example.prj_crud_spring_boot_mongodb.repository;

import com.example.prj_crud_spring_boot_mongodb.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {

    List<Curso> findByNombreContainingIgnoreCase(String nombre);
    List<Curso> findByDocenteContainingIgnoreCase(String docente);
}