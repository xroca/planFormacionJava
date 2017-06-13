/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.utilidades;

import com.curso.lambdas.modelo.Album;
import com.curso.lambdas.modelo.Artista;
import com.curso.lambdas.modelo.Pista;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;

/**
 *
 * @author Chema
 */
public interface Util {

    static List<Artista> todosLosArtistas() {
        return new ArrayList<>();
    }

    static List<Album> todosLosAlbums() {
        return new ArrayList<>();
    }

    static List<Pista> pistas() {
        return asList(new Pista("Bakai", 524),
                new Pista("Violets for Your Furs", 378),
                new Pista("Time Was", 451));
    }
}
