/*
 * ListaPersonas.java
 *
 * Created on 14-sep-2007, 12:57:09
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class ListaPersonas {

    List<Persona> personas = new ArrayList<Persona>();

    public List<Persona> getPersonas() {
        return personas;
    }

    public ListaPersonas() {
        for (int i = 0; i < 5; i++) {
            Persona p = new Persona("Nombre" + i);
            personas.add(p);
        }
    }
}
