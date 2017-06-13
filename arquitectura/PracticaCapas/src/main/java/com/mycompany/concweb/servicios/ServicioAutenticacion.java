/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concweb.servicios;

import com.mycompany.concweb.dao.VehiculoDao;
import com.mycompany.concweb.modelo.Vehiculo;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author iconotc
 */
@Stateless
public class ServicioAutenticacion {

    @Inject
    private VehiculoDao dao;

    public Integer existencias(Vehiculo v) {

        return dao.contarVehiculosMarcaPrecio(v);
    }
}
