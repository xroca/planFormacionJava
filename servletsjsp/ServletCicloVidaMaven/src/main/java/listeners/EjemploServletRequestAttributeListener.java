/*
 * NewServletListener.java
 *
 * Created on 18-sep-2007, 20:25:55
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Web application lifecycle listener.
 *
 * @author Chema
 */
public class EjemploServletRequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo a\u00f1adido.El objeto que ha sido a\u00f1adido es {0}", evento.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo eliminado.El objeto que ha sido a\u00f1adido es {0}", evento.getValue());
    }

    /**
     *
     * @param evento
     */
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent evento) {
        Logger.getLogger("global").log(Level.INFO, "Atributo reemplazado.El objeto que ha sido a\u00f1adido es {0}", evento.getValue());
    }
}
