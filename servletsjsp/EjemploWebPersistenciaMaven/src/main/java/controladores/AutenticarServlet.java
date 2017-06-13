/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jose maria
 */
public class AutenticarServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
    }

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("EjemploWebPersistenciaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select u from Usuario u");
        q.setFirstResult(0);
        q.setMaxResults(1);
        List<Usuario> usuarios = q.getResultList();
        if (usuarios.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                Usuario u = new Usuario("Nombre" + i, "Clave" + i);
                em.persist(u);
            }
        }
        em.getTransaction().commit();
        em.close();
    }

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

        String nombre = request.getParameter("txtNombre");
        String clave = request.getParameter("txtClave");

        Usuario u = null;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            Query q = em.createQuery("select u from Usuario u where u.nombre = :nombre and u.clave = :clave");
            q.setParameter("nombre", nombre);
            q.setParameter("clave", clave);
            u = (Usuario) q.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AutenticarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AutenticarServlet at " + request.getContextPath() + "</h1>");
            out.println("El usuario " + nombre + (u != null ? " existe" : " no existe"));
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
}
