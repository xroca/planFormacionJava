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
public class PrincipalGetNow {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lista = Arrays.asList("A", "B", "C", "D");
        lista.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> s + s))
                .map(f -> f.getNow("Inacabado")).forEach(out::println);
        out.println("Fin");
    }

}
