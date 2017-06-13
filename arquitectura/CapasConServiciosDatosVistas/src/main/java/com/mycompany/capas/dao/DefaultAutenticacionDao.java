/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capas.dao;

import com.mycompany.capas.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
class DefaultAutenticacionDao implements AutenticacionDao {

    private final EntityManagerFactory emf;

    public DefaultAutenticacionDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Boolean existe(Usuario aBuscar) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select u from Usuario u where u.nombre=:nombre and u.clave=:clave");
        q.setParameter("nombre", aBuscar.getNombre());
        q.setParameter("clave", aBuscar.getClave());
        List<Usuario> resultado = q.getResultList();
        em.getTransaction().commit();
        return resultado.size() == 1;
    }

    @Override
    public Usuario guardar(Usuario nuevo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(nuevo);
        em.getTransaction().commit();
        return nuevo;
    }

}
