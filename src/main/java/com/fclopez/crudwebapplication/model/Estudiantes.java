/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fclopez.crudwebapplication.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author flopez
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name="Student.getAll",query = "SELECT e FROM Estudiantes e"))
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int idEstudiante;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;

    public Estudiantes(int idEstudiante, String nombre, String apellido, int edad) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Estudiantes() {
    }
    
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
