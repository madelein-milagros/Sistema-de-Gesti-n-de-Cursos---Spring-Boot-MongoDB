package com.example.prj_crud_spring_boot_mongodb.controller;

import com.example.prj_crud_spring_boot_mongodb.model.Curso;
import com.example.prj_crud_spring_boot_mongodb.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/test-conexion")
    public String testConexion() {
        try {
            long count = cursoRepository.count();
            return "Conexión exitosa! Número de cursos en la base de datos: " + count;
        } catch (Exception e) {
            return "Error de conexión: " + e.getMessage();
        }
    }
    @GetMapping("/ver-datos-json")
    @ResponseBody
    public List<Curso> verDatosJson() {
        return cursoRepository.findAll();
    }

    @GetMapping("/estadisticas")
    @ResponseBody
    public String verEstadisticas() {
        List<Curso> cursos = cursoRepository.findAll();

        int totalCursos = cursos.size();
        int cursosAvanzados = (int) cursos.stream().filter(c -> c.getCreditos() > 3).count();
        int totalHoras = cursos.stream().mapToInt(Curso::getHoras).sum();
        long totalDocentes = cursos.stream().map(Curso::getDocente).distinct().count();

        return "<h1>📊 Estadísticas del Sistema</h1>" +
                "<div class='stats'>" +
                "<p>📚 Total Cursos: " + totalCursos + "</p>" +
                "<p>⭐ Cursos Avanzados: " + cursosAvanzados + "</p>" +
                "<p>⏰ Horas Totales: " + totalHoras + "</p>" +
                "<p>👨‍🏫 Docentes Activos: " + totalDocentes + "</p>" +
                "</div>" +
                "<a href='/cursos'>Volver al listado</a>";
    }
}