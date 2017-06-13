/*
 * Persona.java
 *
 * Created on 14-sep-2007, 12:56:25
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author user
 */
public class Persona {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }
}
