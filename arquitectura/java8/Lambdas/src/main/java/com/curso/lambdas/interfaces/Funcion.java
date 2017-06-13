/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

/**
 *
 * @author Chema
 * @param <Argumento>
 * @param <Resultado>
 */
@FunctionalInterface
public interface Funcion<Argumento, Resultado> {

    Resultado aplicar(Argumento a);
}
