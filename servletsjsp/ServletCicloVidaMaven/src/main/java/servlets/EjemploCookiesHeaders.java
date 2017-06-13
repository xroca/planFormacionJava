/*
 * EjemploCookiesHeaders.java
 *
 * Created on 18-sep-2007, 21:11:09
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Carmen
 */
public class EjemploCookiesHeaders extends HttpServlet {

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
        Cookie c = new Cookie("primera", "primera cookie");
        response.addCookie(c);
        response.addHeader("unHeader", "Un header");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet EjemploCookiesHeaders</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet EjemploCookiesHeaders at " + request.getContextPath() + "</h1>");
        out.println("<ul>");
        for (Cookie cookie : request.getCookies()) {
            out.format("<li>Nombre:%s. Valor:%s</li>", cookie.getName(), cookie.getValue());
        }
        out.println("</ul>");
        @SuppressWarnings(value = "unchecked")
        Enumeration<String> e = request.getHeaderNames();
        out.println("<ul>");

        while (e.hasMoreElements()) {
            String nombre = e.nextElement();
            out.format("<li>Nombre de la cebecera Http: %s. Valor: %s</li>", nombre, request.getHeader(nombre));
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        out.close();
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
