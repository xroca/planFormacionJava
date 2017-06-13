/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.beans;

import java.util.concurrent.Future;
import java.util.stream.Stream;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 *
 * @author usuario
 */
@Service
public class ServicioAsincrono {

    @Async
    public void metodoUno() {
        System.out.println("En metodoUno de " + getClass().getName() + " en el hilo " + Thread.currentThread());
    }

    @Async
    public Future<Double> factorial(Integer numero) {
        System.out.println("En factorial de " + getClass().getName() + " en el hilo " + Thread.currentThread());
        return new AsyncResult<>(factorialUtil(numero));
    }

    @Async
    public ListenableFuture<Double> factorialLf(Integer numero) {
        System.out.println("En factorial de " + getClass().getName() + " en el hilo " + Thread.currentThread());
        return new AsyncResult<>(factorialUtil(numero));
    }

    private Double factorialUtil(Integer numero) {
        return Stream.iterate(1, i -> i + 1)
                .limit(numero)
                .mapToDouble(Double::new)
                .reduce(1.0d, (a, b) -> a * b);
    }

    private Double factorialUtil1(Integer numero) {
        if (numero <= 1) {
            return 1.0;
        } else {
            return numero * factorialUtil(numero - 1);
        }
    }
}
