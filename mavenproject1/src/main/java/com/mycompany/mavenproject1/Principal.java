/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import static java.lang.System.out;
import java.util.List;

/**
 *
 * @author xrocal
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDao dao = Factoria.get();
        dao.nueva(new Persona());
        dao.todos().forEach(out::println);
        dao.todos().forEach(persona -> System.out.println(persona));
        List<Persona> l = dao.todos();
        for (Persona persona : l) {
            System.out.println(persona);
        }
    }

}
