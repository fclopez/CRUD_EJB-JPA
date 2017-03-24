/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fclopez.crudwebapplication.dao;

import com.fclopez.crudwebapplication.model.Estudiantes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author flopez
 */
@Stateless
public class EstudianteDAO implements EstudianteDAOLocal {
    
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }
    
    @Override
    public void createEstudianete(Estudiantes estudiante) {
        getEm().persist(estudiante);
    }

    @Override
    public void editEstudiante(Estudiantes estudiante) {
        getEm().merge(estudiante);
    }

    @Override
    public void deleteEstidiante(int idEstudiante) {
        getEm().remove(getEstudiante(idEstudiante));
    }

    @Override
    public Estudiantes getEstudiante(int idEstudiante) {
        return  getEm().find(Estudiantes.class,idEstudiante);
    }

    @Override
    public List<Estudiantes> getAllEstudiantes() {
        return getEm().createNamedQuery("Student.getAll").getResultList();
    }



    
}
