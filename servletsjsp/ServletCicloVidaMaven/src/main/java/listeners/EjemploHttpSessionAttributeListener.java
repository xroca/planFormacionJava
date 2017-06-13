/*
 * EjemploHttpSessionAttributeListener.java
 *
 * Created on 18-sep-2007, 20:15:17
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author Chema
 */
public class EjemploHttpSessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo a\u00f1adido.El objeto que ha sido a\u00f1adido es {0}", evento.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo eliminado.El objeto que ha sido eliminado es {0}", evento.getValue());
    }

    /**
     *
     * @param evento
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo reemplazado.El objeto reemplazado es {0}", evento.getValue());
    }
}
