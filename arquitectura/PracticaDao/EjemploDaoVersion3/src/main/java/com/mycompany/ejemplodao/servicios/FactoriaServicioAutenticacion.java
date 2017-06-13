/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao.servicios;

/**
 *
 * @author dpalomar
 */
public abstract class FactoriaServicioAutenticacion {
    private static final ServicioAutenticacion SERVICIO = new ServicioAutenticacionImpl();
    public static ServicioAutenticacion get(){
        return SERVICIO;
    }
}
