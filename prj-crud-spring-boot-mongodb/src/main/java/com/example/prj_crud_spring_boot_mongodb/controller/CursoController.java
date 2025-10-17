package com.example.prj_crud_spring_boot_mongodb.controller;


import com.example.prj_crud_spring_boot_mongodb.model.Curso;
import com.example.prj_crud_spring_boot_mongodb.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Listar todos los cursos
    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.getAllCursos();
        model.addAttribute("cursos", cursos);
        model.addAttribute("titulo", "Lista de Cursos");
        return "listarView";
    }

    // Mostrar formulario para nuevo curso
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("curso", new Curso());
        model.addAttribute("titulo", "Nuevo Curso");
        model.addAttribute("accion", "Guardar");
        return "formView";
    }

    // Guardar nuevo curso
    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute Curso curso) {
        System.out.println("DEBUG: Recibiendo curso para guardar: " + curso);

        if (curso.getId() == null || curso.getId().isEmpty()) {
            curso.setId(null); // Asegurar que MongoDB genere un nuevo ID
            cursoService.createCurso(curso);
        } else {
            cursoService.updateCurso(curso.getId(), curso);
        }
        return "redirect:/cursos";
    }

    // Mostrar formulario para editar curso
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Optional<Curso> curso = cursoService.getCursoById(id);
        if (curso.isPresent()) {
            model.addAttribute("curso", curso.get());
            model.addAttribute("titulo", "Editar Curso");
            model.addAttribute("accion", "Actualizar");
            return "formView";
        }
        return "redirect:/cursos";
    }

    // Eliminar curso
    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable String id) {
        cursoService.deleteCurso(id);
        return "redirect:/cursos";
    }

    // Buscar cursos por nombre
    @GetMapping("/buscar")
    public String buscarCursos(@RequestParam String nombre, Model model) {
        List<Curso> cursos = cursoService.searchByNombre(nombre);
        model.addAttribute("cursos", cursos);
        model.addAttribute("titulo", "Resultados de búsqueda: " + nombre);
        return "listarView";
    }

    // Página de debug
    @GetMapping("/debug")
    @ResponseBody
    public String debugInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== DEBUG INFO ===<br>");

        try {
            List<Curso> cursos = cursoService.getAllCursos();
            info.append("✅ Total cursos en BD: ").append(cursos.size()).append("<br>");
            info.append("📋 Cursos:<br>");

            if (cursos.isEmpty()) {
                info.append("   - No hay cursos registrados aún<br>");
            } else {
                for (Curso curso : cursos) {
                    info.append("   - ").append(curso.getNombre())
                            .append(" (ID: ").append(curso.getId())
                            .append(", Créditos: ").append(curso.getCreditos())
                            .append(")<br>");
                }
            }

            info.append("<br>🔗 <a href='/cursos'>Ir a la lista de cursos</a><br>");
            info.append("🔗 <a href='/cursos/nuevo'>Crear nuevo curso</a>");

        } catch (Exception e) {
            info.append("❌ Error al obtener cursos: ").append(e.getMessage());
        }

        return info.toString();
    }
}