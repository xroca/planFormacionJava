/*
 * EjemploListener.java
 *
 * Created on July 26, 2005, 12:57 PM
 */
package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

/**
 *
 * @author paris
 * @version
 *
 * Web application lifecycle listener.
 */
public class EjemploListener implements ServletContextListener {

    /**
     * ### Method from ServletContextListener ###
     *
     * Called when a Web application is first ready to process requests (i.e. on
     * Web server startup and when a context is added or reloaded).
     *
     * For example, here might be database connections established and added to
     * the servlet context attributes.
     * @param evt
     */
    @Override
    public void contextInitialized(ServletContextEvent evt) {
        // TODO add your code here e.g.:
        /*
         Connection con = // create connection
         evt.getServletContext().setAttribute("con", con);
         */
        evt.getServletContext().setAttribute("attrListener", "Valor del atributo de este listener");
    }

    /**
     * ### Method from ServletContextListener ###
     *
     * Called when a Web application is about to be shut down (i.e. on Web
     * server shutdown or when a context is removed or reloaded). Request
     * handling will be stopped before this method is called.
     *
     * For example, the database connections can be closed here.
     * @param evt
     */
    @Override
    public void contextDestroyed(ServletContextEvent evt) {
        // TODO add your code here e.g.:
        /*
         Connection con = (Connection) e.getServletContext().getAttribute("con");
         try { con.close(); } catch (SQLException ignored) { } // close connection
         */
    }
}
