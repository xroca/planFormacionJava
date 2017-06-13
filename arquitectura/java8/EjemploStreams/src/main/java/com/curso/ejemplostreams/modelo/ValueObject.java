/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplostreams.modelo;

import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

/**
 *
 * @author usuario
 */
@Value.Immutable
interface ValueObject {

    long id();

    String name();

    List<Number> numbers();

    Optional<String> comment();

    long[] data();
}
