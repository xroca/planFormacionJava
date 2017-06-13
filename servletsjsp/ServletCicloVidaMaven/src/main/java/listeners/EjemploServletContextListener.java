package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * EjemploServletContextListener.java
 *
 * Created on 18-sep-2007, 19:21:34
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Web application lifecycle listener.
 *
 * @author Chema
 */
public class EjemploServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Contexto inicializado.El objeto que ha lanzado este evento es del tipo {0}", evento.getClass().getName());
    }

    /**
     *
     * @param evento
     */
    @Override
    public void contextDestroyed(ServletContextEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Contexto destru\u00eddo.El objeto que ha lanzado este evento es del tipo {0}", evento.getClass().getName());
    }
}
