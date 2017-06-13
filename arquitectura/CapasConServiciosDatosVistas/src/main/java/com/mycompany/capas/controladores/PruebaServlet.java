/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capas.controladores;

import com.mycompany.capas.modelo.Usuario;
import com.mycompany.capas.servicio.FactoriaServicio;
import com.mycompany.capas.servicio.ServicioAutenticacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class PruebaServlet extends HttpServlet {

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
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave");
        Usuario u = new Usuario(nombre, clave);
        ServicioAutenticacion s = FactoriaServicio.unicaInstancia();

        if (s.autenticar(u)) {
            generarPagina1(request, response, u);
        } else {
            generarPagina2(request, response, u);
        }
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

    private void generarPagina1(HttpServletRequest request, HttpServletResponse response, Usuario u) throws IOException, ServletException {
        request.setAttribute("usuario", u);
        getServletContext().getRequestDispatcher("/autenticado.jsp").forward(request, response);
    }

    private void generarPagina2(HttpServletRequest request, HttpServletResponse response, Usuario u) throws IOException, ServletException {
        request.setAttribute("usuario", u);
        getServletContext().getRequestDispatcher("/noautenticado.jsp").forward(request, response);
    }

}
