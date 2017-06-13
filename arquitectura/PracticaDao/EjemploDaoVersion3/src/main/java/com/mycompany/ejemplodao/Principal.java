/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

import com.mycompany.ejemplodao.modelo.Persona;
import com.mycompany.ejemplodao.servicios.FactoriaServicioAutenticacion;
import com.mycompany.ejemplodao.servicios.ServicioAutenticacion;

/**
 *
 * @author usuario
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicioAutenticacion servicio = FactoriaServicioAutenticacion.get();        
        System.out.println(
                servicio.autenticar(new Persona(123L,"abc"))
                ? "Autenticado" : "No autenticado"
        );
        System.out.println(
                servicio.autenticar(new Persona(123L,"abc123"))
                ? "Autenticado" : "No autenticado"
        );        
    }

}
