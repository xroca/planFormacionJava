/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capas.servicio;

/**
 *
 * @author Administrador
 */
public abstract class FactoriaServicio {
   private static final ServicioAutenticacion S = new DefaultAutenticacion();
   public static ServicioAutenticacion unicaInstancia(){
       return S;
   }
}
