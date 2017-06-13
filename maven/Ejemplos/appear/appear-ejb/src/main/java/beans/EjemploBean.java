/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;

/**
 *
 * @author usuario
 */
@Stateless
public class EjemploBean implements EjemploBeanLocal {

    @Override
    public String mensaje(final String texto) {
        return "El mensaje es " + texto.toUpperCase();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
