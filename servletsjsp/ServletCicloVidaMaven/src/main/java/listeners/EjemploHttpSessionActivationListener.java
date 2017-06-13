/*
 * EjemploHttpSessionActivationListener.java
 *
 * Created on 18-sep-2007, 20:07:27
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 *
 * @author Chema
 */
public class EjemploHttpSessionActivationListener implements HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "El estado de la sesión va a ser llevado a almacenamientopersistente");
    }

    /**
     *
     * @param evento
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "El estado de la sesión fue recuperado desde almacenamientopersistente");
    }
}
