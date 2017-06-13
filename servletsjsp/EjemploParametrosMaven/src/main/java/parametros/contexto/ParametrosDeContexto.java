/*
 * ParametrosDeContexto.java
 *
 * Created on July 26, 2005, 12:27 PM
 */
package parametros.contexto;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author paris
 * @version
 */
public class ParametrosDeContexto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ParametrosDeContexto</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ParametrosDeContexto at " + request.getContextPath() + "</h1>");
        String s = getServletContext().getInitParameter("ParametroUno");
        out.println(s + "<br>");
        if (request.getParameter("inicio") != null) {
            out.println("La servlet ha recibido como parámetro el valor:" + request.getParameter("inicio") + ".");
            out.println("<br>");
        }
        if (getInitParameter("ParametroInitUno") != null) {
            out.println("La servlet ha recibido como parámetro de inicialización el valor:" + getInitParameter("ParametroInitUno"));
            out.println("<br>");
        }
        if (getServletContext().getAttribute("attrListener") != null) {
            out.println("El valor de un atributo de un servlet listener es:" + getServletContext().getAttribute("attrListener"));
            out.println("<br>");
        }
        if (request.getAttribute("ElParametro") != null) {
            out.println("El valor de un parámetro pasado por un filtro es: " + request.getAttribute("ElParametro"));
        }
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
