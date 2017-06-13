/*
 * Greeter.java
 *
 * Created on 10-sep-2007, 19:30:32
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package demo.tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

/**
 *
 * @author user
 */
public class Saludo extends SimpleTagSupport {

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
            out.println("Mensaje desde una etiqueta personalizada");
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
}