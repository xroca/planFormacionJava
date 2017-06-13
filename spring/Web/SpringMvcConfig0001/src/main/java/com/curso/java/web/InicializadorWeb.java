/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.web;

import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author jose maria
 */
public class InicializadorWeb implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("spring.profiles.active", "produccion");
        AnnotationConfigWebApplicationContext raiz = new AnnotationConfigWebApplicationContext();
        raiz.scan("com.curso.java.config");
        servletContext.addListener(new ContextLoaderListener(raiz));
        ServletRegistration.Dynamic appServlet =
                servletContext.addServlet("appServlet", new DispatcherServlet(raiz));
        appServlet.setLoadOnStartup(1);
        Set<String> conflictos = appServlet.addMapping("/");
        if (!conflictos.isEmpty()) {
            throw new IllegalStateException("La versión de Tomcat debe ser mayor que 7.0.14");
        }
    }
}
