/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplostreams.utilidades;

import com.curso.ejemplostreams.modelo.Persona;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.System.out;
import static java.util.Collections.*;
import java.util.List;
import java.util.Objects;
import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author usuario
 */
public interface Util {
    
    static Stream<Persona> personas(final Integer inicio, final Integer fin) {
        Objects.requireNonNull(inicio);
        Objects.requireNonNull(fin);
        Persona plantilla = Persona.of("", 0, emptyList());
        return IntStream.rangeClosed(min(inicio, fin), max(inicio, fin))
                .mapToObj(n -> plantilla.conNombre("Nombre" + n).conEdad(n).conNicks("Nick" + n))
                .limit(max(inicio, fin));
    }
    
    static <T> void mostrar(final Stream<T> s) {
        s.forEach(out::println);
        out.println();
    }
    
    static <T> List<T> toLista(Stream<T> s) {
        return s.collect(toList());
    }
}
