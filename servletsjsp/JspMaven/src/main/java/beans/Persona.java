/*
 * Persona.java
 *
 * Created on 18 de febrero de 2004, 20:15
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author x
 */
public class Persona implements Serializable {

    private String nombre = "una persona";

    private int edad = 20;

    /**
     * Creates a new instance of Persona
     */
    public Persona() {
    }

    /**
     * Getter for property nombre.
     *
     * @return Value of property nombre.
     *
     */
    public java.lang.String getNombre() {
        return nombre;
    }

    /**
     * Setter for property nombre.
     *
     * @param nombre New value of property nombre.
     *
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter for property edad.
     *
     * @return Value of property edad.
     *
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter for property edad.
     *
     * @param edad New value of property edad.
     *
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
