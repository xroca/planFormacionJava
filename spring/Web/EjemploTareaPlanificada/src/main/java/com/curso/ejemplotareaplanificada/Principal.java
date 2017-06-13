/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplotareaplanificada;

import com.curso.beans.ServicioAsincrono;
import com.curso.config.Configuracion;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
        System.out.println("Contexto cargado");
        ServicioAsincrono sa = ctx.getBean(ServicioAsincrono.class);
        System.out.println("Hilo principal " + Thread.currentThread());
        sa.metodoUno();
        Future<Double> numero = sa.factorial(100);
        try {
            System.out.println("El factorial es desde un Future:" + numero.get(5L, TimeUnit.SECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListenableFuture<Double> valor = sa.factorialLf(100);
        valor.addCallback(new ListenableFutureCallback<Double>() {

            @Override
            public void onSuccess(Double result) {
                System.out.println("El resultado es desde un ListenableFuture: " + result);
            }

            @Override
            public void onFailure(Throwable ex) {
                LOG.log(Level.SEVERE, "Ha ocurrido un error:", ex);
            }
        });
    }
    private static final Logger LOG = Logger.getLogger(Principal.class.getName());

}
