/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.rangos;

import static java.lang.System.out;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal p = new Principal();
        p.iteraciones(5, () -> p.randomize(1,1000).filter(n -> n < 500).sorted());
        p.iteraciones(5, () -> p.randomize(1,1000).parallel().filter(n -> n < 500).sorted());
        p.streamInfinito().limit(10).forEach(out::println);
    }
    
    IntStream randomize(Integer inicio, Integer fin){
        List<Integer> l = IntStream.rangeClosed(inicio, fin).collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        Collections.shuffle(l);
        return l.stream().mapToInt(i->i);
    }
    
    IntStream streamInfinito() {        
        return IntStream.iterate(0, i -> i + 2);
    }
    
    Long medidor(Runnable r) {
        Long comienzo = System.nanoTime();
        r.run();
        return System.nanoTime() - comienzo;
    }
    
    void iteraciones(Integer veces, Runnable r) {
        OptionalDouble media = LongStream.range(0, veces).map(i -> medidor(r)).average();
        System.out.format("Tiempo medio %s nanosegundos tras %d ejecuciones%n", media.orElse(0), veces);
    }
}
