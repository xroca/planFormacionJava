/*
 * EjemploServletContextAttributeListener.java
 *
 * Created on 18-sep-2007, 19:32:52
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Web application lifecycle listener.
 *
 * @author Chema
 */
public class EjemploServletContextAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo a\u00f1adido.El objeto que ha sido a\u00f1adido es {0}", evento.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo eliminado.El objeto que ha sido eliminado es {0}", evento.getValue());
    }

    /**
     *
     * @param evento
     */
    @Override
    public void attributeReplaced(ServletContextAttributeEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo reemplazado.El objeto reemplazado es {0}", evento.getValue());
    }
}
