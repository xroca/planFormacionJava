/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

/**
 *
 * @author Chema
 */
public class UsoInterfazFuncional {

    private final InterfazFuncional lambda = numero -> numero.toString();

    public String metodo(InterfazFuncional i, Integer n) {
        String s = i.ejemplo(n);
        return "El valor es " + s;
    }

    public InterfazFuncional metodo1(Integer valor) {
        return argumento -> Integer.toString(argumento * valor);
    }

    public void llamarMetodo() {
        System.out.println(metodo(lambda, 12));
        System.out.println(metodo(argumento -> "Resultado: " + argumento * 2, 12));
        InterfazFuncional i = metodo1(10);
        System.out.println(metodo(i, 20));
    }
}
