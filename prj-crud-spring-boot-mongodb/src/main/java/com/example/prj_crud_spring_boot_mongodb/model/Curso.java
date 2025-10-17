package com.example.prj_crud_spring_boot_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cursos")
public class Curso {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("creditos")
    private Integer creditos;

    @Field("docente")
    private String docente;

    @Field("horas")
    private Integer horas;

    // Constructores
    public Curso() {}

    public Curso(String nombre, Integer creditos, String docente, Integer horas) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
        this.horas = horas;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }

    public String getDocente() { return docente; }
    public void setDocente(String docente) { this.docente = docente; }

    public Integer getHoras() { return horas; }
    public void setHoras(Integer horas) { this.horas = horas; }

    @Override
    public String toString() {
        return "Curso{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditos=" + creditos +
                ", docente='" + docente + '\'' +
                ", horas=" + horas +
                '}';
    }
}