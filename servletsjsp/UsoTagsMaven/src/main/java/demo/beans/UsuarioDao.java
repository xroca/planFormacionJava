/*
 * GestorUsuario.java
 *
 * Created on 10-sep-2007, 20:15:19
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class UsuarioDao {

    private static final List<Usuario> usuarios = new ArrayList<Usuario>();

    public UsuarioDao() {
    }
    static {
        for (Long i = 0L; i < 5L; i++) {
            Usuario u = new Usuario(i, "Nombre" + i, "Clave " + i);
            usuarios.add(u);
        }
    }

    public static void rellenarUsuario(Usuario u, Long id) {
        if (u == null) {
            u = new Usuario(0L, "Sin definir", "Sin definir");
        }
        for (Usuario usuario : usuarios) {
            if (usuario.getId().longValue() == id.longValue()) {
                u.setId(usuario.getId());
                u.setClave(usuario.getClave());
                u.setNombre(usuario.getNombre());
                break;
            }
        }
    }
}
