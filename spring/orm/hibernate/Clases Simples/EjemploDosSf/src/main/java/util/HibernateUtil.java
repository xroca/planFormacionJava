/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Chema
 */
public class HibernateUtil {

    private static final SessionFactory SESSIONFACTORYUNO;
    private static final SessionFactory SESSIONFACTORYDOS;

    static {
        SESSIONFACTORYUNO = crearSesionFactory("recursos/sesionuno.cfg.xml");
        SESSIONFACTORYDOS = crearSesionFactory("recursos/sesiondos.xml");

    }

    public static SessionFactory getSessionFactoryUno() {
        return SESSIONFACTORYUNO;
    }

    public static SessionFactory getSessionFactoryDos() {
        return SESSIONFACTORYDOS;
    }

    private static SessionFactory crearSesionFactory(String recurso) throws ExceptionInInitializerError {
        SessionFactory sf;
        try {
            // Crear la factoría de sesiones definida por el parámetro 'recurso'
            Configuration conf = new Configuration().configure(recurso);
            ServiceRegistry s = new ServiceRegistryBuilder().applySettings(
                    conf.getProperties()).buildServiceRegistry();
            sf = conf.buildSessionFactory(s);
            System.out.format("Factoría de sesiones %s creada.\n", recurso);
            return sf;
        } catch (HibernateException ex) {
            System.err.println("La creación de la factoría de sesiones ha fallado." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
