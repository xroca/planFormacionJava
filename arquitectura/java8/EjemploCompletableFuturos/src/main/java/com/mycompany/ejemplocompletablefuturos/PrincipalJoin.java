/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplocompletablefuturos;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Chema
 */
public class PrincipalJoin {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        List<Integer> lista = Arrays.asList(10, 20, 30, 40);
        lista.stream()
                .map(dato -> CompletableFuture.supplyAsync(() -> getNumero(dato)))
                .map(compFuture -> compFuture.thenApply(n -> n * n))
                .map(t -> t.join()).forEach(out::println);
        out.println("Fin");
    }

    private static int getNumero(int a) {
        return a * a;
    }
}
