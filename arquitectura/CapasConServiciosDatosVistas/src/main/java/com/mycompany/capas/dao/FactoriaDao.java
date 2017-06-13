/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capas.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrador
 */
public abstract class FactoriaDao {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PersistenciaPU");
    private static final AutenticacionDao S = new DefaultAutenticacionDao(EMF);

    static {
        Runtime.getRuntime().addShutdownHook(
                new Thread() {
                    @Override
                    public void run() {
                        if (EMF != null) {
                            EMF.close();
                        }
                    }

                }
        );
    }

    public static AutenticacionDao unicaInstancia() {
        return S;
    }
}
