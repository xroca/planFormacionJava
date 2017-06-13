/*
 * NewServletListener.java
 *
 * Created on 18-sep-2007, 20:21:38
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Web application lifecycle listener.
 *
 * @author Chema
 */
public class EjemploServletRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Petición (request) destruída");
    }

    /**
     *
     * @param evento
     */
    @Override
    public void requestInitialized(ServletRequestEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Petición (request) inicializada");
    }
}
