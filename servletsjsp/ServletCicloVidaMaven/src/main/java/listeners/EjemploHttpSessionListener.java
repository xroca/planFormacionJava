/*
 * EjemploHttpSessionListener.java
 * 
 * Created on 18-sep-2007, 19:46:35
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Chema
 */
public class EjemploHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Sesi\u00f3n creada.Su identificador es {0}", evento.getSession().getId());
    }

    /**
     *
     * @param evento
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Sesi\u00f3n destru\u00edda.Su identificador es {0}", evento.getSession().getId());
    }
}
