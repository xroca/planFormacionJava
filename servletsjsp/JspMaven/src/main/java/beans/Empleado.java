/*
 * Empleado.java
 *
 * Created on 19 de febrero de 2004, 19:10
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author x
 */
public class Empleado implements Serializable {

    private String nombre = "Sin nombre";

    private String apellido = "Sin Apellido";

    /**
     * Creates a new instance of Empleado
     */
    public Empleado() {
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
     * Getter for property apellido.
     *
     * @return Value of property apellido.
     *
     */
    public java.lang.String getApellido() {
        return apellido;
    }

    /**
     * Setter for property apellido.
     *
     * @param apellido New value of property apellido.
     *
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }

    public static Empleado[] listaEmpleadosOrdenadosPorNombre(final java.lang.String nombre) {
        Empleado[] emp = new Empleado[10];
        for (int i = 0; i < emp.length; i++) {
            emp[i] = new Empleado();
            emp[i].setNombre(emp[i].getNombre() + System.currentTimeMillis());
        }
        return emp;
    }

}
