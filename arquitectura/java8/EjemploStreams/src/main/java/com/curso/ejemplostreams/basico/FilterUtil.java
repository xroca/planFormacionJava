/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplostreams.basico;

import com.curso.ejemplostreams.modelo.Persona;
import static com.curso.ejemplostreams.utilidades.Util.personas;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author usuario
 */
public interface FilterUtil {

    static Stream<Persona> ejemploFilter() {
        return personas(1, 10).filter(p -> p.getEdad() < 5);
    }

    static Stream<Persona> ejemploFilter(Predicate<Persona> p) {
        return personas(1, 10).filter(p);
    }
}
