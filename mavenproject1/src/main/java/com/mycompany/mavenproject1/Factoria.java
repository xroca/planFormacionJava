/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author xrocal
 */
public class Factoria {

    private Factoria() {
    }
    private static final PersonaDao dao = new BaseDatosMem();

    public static PersonaDao get() {
        return dao;
    }
}
