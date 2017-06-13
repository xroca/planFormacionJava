/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.practicaposiblesolucion.mensajes;

import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author formacioncoruna
 * @param <T>
 */
public class Mensaje<T> {

    public enum EstadosMensaje {

        LEIDO, SINLEER
    }

    public static <T> Mensaje<T> crearMensaje(T contenido) {
        return crearMensaje(contenido, Optional.empty());
    }

    public <T> Mensaje conEstado(EstadosMensaje e) {
        return new Mensaje<>(contenido, Optional.ofNullable(e));
    }

    private static <T> Mensaje<T> crearMensaje(T contenido, Optional<EstadosMensaje> e) {
        Objects.requireNonNull(contenido, "El contenido del mensaje es nulo");
        return new Mensaje<>(contenido, e);
    }
    private final T contenido;

    private final Optional<EstadosMensaje> estado;

    private Mensaje(T contenido, Optional<EstadosMensaje> e) {
        this.contenido = contenido;
        estado = e;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.contenido);
        hash = 97 * hash + Objects.hashCode(this.estado);
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
        final Mensaje<?> other = (Mensaje<?>) obj;
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        return Objects.equals(this.estado, other.estado);
    }



    public Boolean leido() {
        return estado.map(e -> e == EstadosMensaje.LEIDO).orElse(false);
    }

    public Boolean sinLeer() {
        return !leido();
    }

    @Override
    public String toString() {
        return "Mensaje{" + "contenido=" + contenido + ", estado=" + estado + '}';
    }

}
