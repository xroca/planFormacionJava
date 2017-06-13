/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class EjemploServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String primerNombre = req.getParameter("primerNombre");
        String segundoNombre = req.getParameter("segundoNombre");

        if (primerNombre != null) {
            req.setAttribute("primerNombre", primerNombre);
        }
        if (segundoNombre != null) {
            req.setAttribute("segundoNombre", segundoNombre);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/ver.jsp");

        rd.forward(req, res);
    }
}
