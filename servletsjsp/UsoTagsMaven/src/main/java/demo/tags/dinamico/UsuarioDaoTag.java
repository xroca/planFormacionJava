/*
 * UsuarioDaoTag.java
 *
 * Created on 11-sep-2007, 10:05:07
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.tags.dinamico;

import demo.beans.Usuario;
import demo.beans.UsuarioDao;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

/**
 *
 * @author user
 */
public class UsuarioDaoTag extends SimpleTagSupport implements DynamicAttributes {

    private Map atributos = new HashMap();

    /**
     * Called by the container to invoke this tag.
     * The implementation of this method is provided by the tag library developer,
     * and handles all tag processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {

        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            Usuario u = (Usuario) atributos.get("usuario");
            String clave = (String) atributos.get("id");
            if (u == null || clave == null) {
                throw new JspException("El usuario y la clave deben existir y no ser nulos");
            }
            UsuarioDao.rellenarUsuario(u, Long.parseLong(clave));
            out.println("<table><thead><th colspan=\"2\" align=\"center\">Datos del usuario " + u.getId() + "</th></thead>");
            out.println("<tr><td>Identificador</td><td>" + u.getId() + "</td></tr>");
            out.println("<tr><td>Nombre</td><td>" + u.getNombre() + "</td></tr>");
            out.println("<tr><td>Clave</td><td>" + u.getClave() + "</td></tr></table>");
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);

                // TODO: insert code to write html after writing the body content.
                // e.g.:
                //
                // out.println("    </blockquote>");
            }
        } catch (java.io.IOException ex) {
            throw new JspException(ex.getMessage());
        }
    }

    public void setDynamicAttribute(String uri, String nombreLocal, Object valor) throws JspException {
        atributos.put(nombreLocal, valor);
    }
}