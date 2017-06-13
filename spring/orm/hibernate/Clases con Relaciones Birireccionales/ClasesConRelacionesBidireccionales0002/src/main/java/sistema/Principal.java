/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import beans.Rol;
import beans.Usuario;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateHook;
import util.HibernateUtil;

/**
 *
 * @author Chema
 */
public class Principal {

    SessionFactory sessionFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.inicializarHibernate();
        Usuario usuario = p.crearUsuario();
        p.mostrarUsuarios();
        p.actualizarUsuario(usuario.getId());
        p.mostrarUsuarios();
        p.borrarUsuario(usuario.getId());
        p.mostrarUsuarios();
//        p.provocarLazyInitializationException();
    }

    private void actualizarUsuario(Long id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Usuario usuario = (Usuario) session.load(Usuario.class, id);
            usuario.setNombre("Nombre de usuario actualizado");
            Rol[] arrRoles = usuario.getRoles().toArray(new Rol[0]);
            arrRoles[0].setNombre("Nombre actualizado");
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void borrarUsuario(Long id) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Usuario usuario = (Usuario) session.load(Usuario.class, id);
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private Usuario crearUsuario() {
        Session session = null;
        Usuario usuario = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            usuario = new Usuario("Uno", "clave uno");
            Rol rol = new Rol("Rol uno");
            session.persist(usuario);
            session.persist(rol);
            usuario.getRoles().add(rol);
            rol.getUsuarios().add(usuario);
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return usuario;
    }

    private void provocarLazyInitializationException() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Query query = session.createQuery("from Rol");
            List<Rol> roles = query.list();
            session.getTransaction().commit();
            if (roles.size() == 0) {
                System.out.println("No hay roles que mostrar");
            } else {
                for (Rol rol : roles) {
                    System.out.println(rol);
                    if (rol.getUsuarios().size() == 0) {
                        System.out.println("Este rol no tiene usuarios asociados");
                    } else {
                        for (Usuario usuario : rol.getUsuarios()) {
                            System.out.println("Nombre del usuario " + usuario.getNombre());
                        }
                    }
                }
            }
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void mostrarUsuarios() {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.getTransaction().begin();
            Query query = session.createQuery("from Usuario");
            List<Usuario> usuarios = query.list();
            if (usuarios.size() == 0) {
                System.out.println("No hay usuarios que mostrar");
            } else {
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario);
                    if (usuario.getRoles().size() == 0) {
                        System.out.println("Este usuario no tiene roles asociados");
                    } else {
                        for (Rol rol : usuario.getRoles()) {
                            System.out.println("Nombre del rol " + rol.getNombre());
                        }
                    }
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback();
            System.out.println("Ha ocurrido un error " + hibernateException);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void inicializarHibernate() {
        Runtime.getRuntime().addShutdownHook(new HibernateHook());
        sessionFactory = HibernateUtil.getSessionFactory();
    }
}
