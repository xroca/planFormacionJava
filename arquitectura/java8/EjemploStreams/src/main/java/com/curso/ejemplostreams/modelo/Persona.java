/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplostreams.modelo;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.Objects;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 *
 * @author usuario
 */
public class Persona {

    private final String nombre;

    private final Integer edad;

    private final List<String> nicks;

    /**
     *
     * @param nombre
     * @param edad
     * @param nicks
     * @return
     */
    public static Persona of(String nombre, Integer edad, List<String> nicks){
        return new Persona(nombre, edad, nicks);
    }
    /**
     *
     * @param nombre
     * @param edad
     * @param nicks
     */
    private Persona(String nombre, Integer edad, List<String> nicks) {
        this.nombre = Objects.requireNonNull(nombre);
        this.edad = Objects.requireNonNull(edad);
        this.nicks = Objects.requireNonNull(nicks);
    }

    /**
     *
     * @return
     */
    public final Stream<String> getNicks() {
        return nicks.stream();
    }

    /**
     *
     * @param nombre
     * @return
     */
    public Persona conNombre(final String nombre) {
        return new Persona(nombre, getEdad(), getNicks().collect(toList()));
    }

    /**
     *
     * @param edad
     * @return
     */
    public Persona conEdad(final Integer edad) {
        return new Persona(getNombre(), edad, getNicks().collect(toList()));
    }

    public Persona conNicks(String... nicks) {
        return new Persona(nombre, edad, asList(nicks));
    }

    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public final Integer getEdad() {
        return edad;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public final String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + getNombre() + ", edad=" + getEdad() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.edad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.edad, other.edad);
    }

}
