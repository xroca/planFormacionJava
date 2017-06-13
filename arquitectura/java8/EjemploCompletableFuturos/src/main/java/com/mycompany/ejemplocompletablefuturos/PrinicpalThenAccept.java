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
public class PrinicpalThenAccept {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("A", "B", "C", "D");
        lista.stream()
                .map(dato -> CompletableFuture.supplyAsync(() -> "Procesando:" + dato))
                .map(compFuture -> compFuture.thenAccept(out::println))
                .count();
        out.println("Fin");
    }

}
