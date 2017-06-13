/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Chema
 */
public class UsoInterfazGenerica {

    private final Funcion<Integer, String> lambda = numero -> numero.toString();

    public String metodo(Funcion<Integer, String> i, Integer n) {
        String s = i.aplicar(n);
        return "El valor es " + s;
    }

    public Funcion<Integer, String> metodo1(Integer valor) {
        return argumento -> Integer.toString(argumento * valor);
    }

    public void llamarMetodo() {
        System.out.println(metodo(lambda, 12));
        System.out.println(metodo(argumento -> "Resultado: " + argumento * 2, 12));
        Funcion<Integer, String> i = metodo1(10);
        System.out.println(metodo(i, 20));
        Pattern p = Pattern.compile("\\n");
    }

    /**
     *
     */
    private final Funcion<String, List<String>> splitter = texto -> {
        Pattern p = Pattern.compile("\\n");
        String[] lineas = p.split(texto);
        return Arrays.asList(lineas);
    };

    public Funcion<String, List<String>> getSplitter() {
        return splitter;
    }
}
