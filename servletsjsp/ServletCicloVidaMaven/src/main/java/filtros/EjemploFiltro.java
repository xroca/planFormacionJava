/*
 * EjemploFiltro.java
 *
 * Created on 18-sep-2007, 20:33:17
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Chema
 */
public class EjemploFiltro implements Filter {

    private FilterConfig filterConfig = null;

    public EjemploFiltro() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (debug) {
            log("EjemploFiltro:DoBeforeProcessing");
        }
        Logger.getLogger("global").log(Level.INFO, "Antes de ejecurar la cadena de filtros");
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (debug) {
            log("EjemploFiltro:DoAfterProcessing");
        }
        Logger.getLogger("global").log(Level.INFO, "Después de ejecurar la cadena de filtros");
        PrintWriter respOut = new PrintWriter(response.getWriter());
        respOut.println("<P><B>Este texto ha sido añadido por un filtro después de procesar la petición (request).</B>");
        respOut.close();
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (debug) {
            log("EjemploFiltro:doFilter()");
        }
        doBeforeProcessing(request, response);

        Throwable problem = null;

        try {
            Logger.getLogger("global").log(Level.INFO, "Ejecutando la cadena de filtros");
            chain.doFilter(request, response);
        } catch (IOException t) {
            problem = t;
            t.printStackTrace();
        } catch (ServletException t) {
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     * @return 
     */
    public FilterConfig getFilterConfig() {
        return this.filterConfig;
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {

        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     *
     */
    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {

        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("EjemploFiltro:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {

        if (filterConfig == null) {
            return "EjemploFiltro()";
        }
        StringBuilder sb = new StringBuilder("EjemploFiltro(");
        sb.append(filterConfig);
        sb.append(")");
        return sb.toString();
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {

        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {

            try {

                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N                
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (IOException ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {

        String stackTrace = null;

        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (IOException ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

    private static final boolean debug = true;
}
