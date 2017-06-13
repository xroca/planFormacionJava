package listeners;

import beans.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Web application lifecycle listener.
 *
 * @author Chema
 */
public class IntegracionListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent evento) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("IntegracionPU");
        evento.getServletContext().setAttribute("emf", emf);
        evento.getServletContext().log("EntityManagerFactory creada");
        cargarBd(emf);
    }

    @Override
    public void contextDestroyed(ServletContextEvent evento) {
        EntityManagerFactory emf = (EntityManagerFactory) evento.getServletContext().getAttribute("emf");
        emf.close();
        evento.getServletContext().log("EntityManagerFactory cerrada");
    }

    private void cargarBd(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (int i = 0; i < 10; i++) {
            Usuario usuario = new Usuario("Usuario " + i);
            em.persist(usuario);
        }
        em.getTransaction().commit();
    }
}
