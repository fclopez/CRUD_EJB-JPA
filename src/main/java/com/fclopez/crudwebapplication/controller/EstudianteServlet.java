/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fclopez.crudwebapplication.controller;

import com.fclopez.crudwebapplication.dao.EstudianteDAOLocal;
import com.fclopez.crudwebapplication.model.Estudiantes;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author flopez
 */
@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

    @EJB
    private EstudianteDAOLocal _edl;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String evento = request.getParameter("evento").toLowerCase();
        String idestud = request.getParameter("idEstudiante");
        int idEstudiante = (idestud != null && !idestud.equals(""))?Integer.parseInt(idestud):0;
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String ed = request.getParameter("edad");
        int edad = (ed != null && !ed.equals(""))?Integer.parseInt(ed):0;
        
        Estudiantes est = new Estudiantes(idEstudiante, nombre, apellido, edad);
        
        switch(evento){
            
            case "add":
                _edl.createEstudianete(est);
                break;
            case "edit":
                _edl.editEstudiante(est);
                break;
            case "delete":
                _edl.deleteEstidiante(idEstudiante);
                break;
            case "search":
                est = _edl.getEstudiante(idEstudiante);
                break;
        }
        
        request.setAttribute("estudiante", est);
        request.setAttribute("allestudiantes", _edl.getAllEstudiantes());
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
