/*
 * EjemploServlet.java
 *
 * Created on 18-sep-2007, 19:30:12
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author Carmen
 */
public class EjemploServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet EjemploServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet EjemploServlet at " + request.getContextPath() + "</h1>");
        getServletContext().setAttribute("primero", "primero");
        getServletContext().setAttribute("primero", "segundo");
        getServletContext().removeAttribute("primero");
        HttpSession sesion = request.getSession();
        sesion.setAttribute("primeroSesion", "primero sesión");
        sesion.setAttribute("primeroSesion", "segundo sesión");
        sesion.removeAttribute("primeroSesion");
        request.setAttribute("primeroRequest", "primero request");
        request.setAttribute("primeroRequest", "segundo request");
        request.removeAttribute("primeroRequest");
        sesion.invalidate();
        out.println("</body>");
        out.println("</html>");
        //out.close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     * @return 
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
