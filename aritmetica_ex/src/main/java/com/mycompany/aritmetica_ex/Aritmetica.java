/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aritmetica_ex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author xrocal
 */
public class Aritmetica {

    public Double media(List<Double> numeros) {

        if (numeros == null) {
            throw new IllegalArgumentException("La lista es nula");
        }
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("La lista está vacía");
        }
        if (numeros.stream().filter(n -> n < 0).count() != 0) {
            throw new RuntimeException("La lista tiene valores negativos");
        }
        return numeros.stream().reduce(0.0, (a, b) -> a + b) / numeros.size();
    }
//    public Double media1(List<Double> numeros) {
//        Stream<Double> negativos = numeros.stream().filter(n -> n < 0);
//        long count = negativos.count();
//        Double acc = 0.0;
//        acc = numeros.stream().reduce(acc, (accumulator, _item) -> accumulator + _item);
//        return  acc / numeros.size();
//    }
}
