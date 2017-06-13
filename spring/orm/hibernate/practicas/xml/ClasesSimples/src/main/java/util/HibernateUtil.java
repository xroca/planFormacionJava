/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Chema
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Crear la factoría de sesesiones leyendo la configuración del archivo hibernate.cfg.xml
            Configuration conf = new Configuration().configure();
            ServiceRegistry s = new ServiceRegistryBuilder().applySettings(
                    conf.getProperties()).buildServiceRegistry();
            sessionFactory = conf.buildSessionFactory(s);
            System.out.println("Factoría de sesiones creada.");
        } catch (Throwable ex) {
            System.err.println("La creación de la factoría de sesiones ha fallado." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
