/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class PruebaServlet extends HttpServlet {

    private final Map<String, String> usuarios = Collections.singletonMap("abc", "xyz");

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
        String s = usuarios.get(nombre);
        Boolean resultado = s == null ? false : s.equals(clave);
        if (resultado) {
            generarPagina1(request, response, nombre, clave);
        } else {
            generarPagina2(request, response, nombre, clave);
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

    private void generarPagina1(HttpServletRequest request, HttpServletResponse response, String nombre, String clave) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PruebaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PruebaServlet at " + request.getContextPath() + "</h1>");
            out.println(String.format("El usuario %s con clave %s está autenticado", nombre, clave));
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void generarPagina2(HttpServletRequest request, HttpServletResponse response, String nombre, String clave) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PruebaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PruebaServlet at " + request.getContextPath() + "</h1>");
            out.println(String.format("El usuario %s con clave %s no está autenticado", nombre, clave));
            out.println("</body>");
            out.println("</html>");
        }
    }

}
