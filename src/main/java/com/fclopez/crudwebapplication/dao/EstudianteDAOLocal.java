/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fclopez.crudwebapplication.dao;

import com.fclopez.crudwebapplication.model.Estudiantes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author flopez
 */
@Local
public interface EstudianteDAOLocal {

    void createEstudianete(Estudiantes estudiante);

    void editEstudiante(Estudiantes estudiante);

    void deleteEstidiante(int idEstudiante);

    Estudiantes getEstudiante(int idEstudiante);

    List<Estudiantes> getAllEstudiantes();
    
}
