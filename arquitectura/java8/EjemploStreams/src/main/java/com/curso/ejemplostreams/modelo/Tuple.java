/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplostreams.modelo;

/**
 *
 * @author usuario
 */
import org.immutables.value.Value;

@Value.Immutable(builder = false, copy = false)
interface Tuple {

    @Value.Parameter
    int getIndex();

    @Value.Parameter
    String getName();
}
