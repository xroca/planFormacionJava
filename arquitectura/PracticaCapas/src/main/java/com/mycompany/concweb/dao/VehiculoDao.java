/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concweb.dao;

import com.mycompany.concweb.modelo.Vehiculo;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author iconotc
 */
@Stateless
public class VehiculoDao {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void cargarBd() {
        for (int i = 1; i < 10; i++) {
            em.persist(new Vehiculo("Ford", i * 1000));
        }
    }

    public Integer contarVehiculosMarcaPrecio(Vehiculo v) {
        final String query = "select v from Vehiculo v where v.marca=:marca and v.precio=:precio";
        Query q = em.createQuery(query);
        q.setParameter("marca", v.getMarca());
        q.setParameter("precio", v.getPrecio());
        return q.getResultList().size();
    }

}
