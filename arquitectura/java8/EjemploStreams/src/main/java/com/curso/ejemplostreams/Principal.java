/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplostreams;

import static com.curso.ejemplostreams.basico.FilterUtil.ejemploFilter;
import static com.curso.ejemplostreams.utilidades.Util.*;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mostrar(personas(1, 10));
        mostrar(personas(10, 1));
        mostrar(ejemploFilter());
    }

}
