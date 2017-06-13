/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.persistencia;

import com.mycompany.persistencia.modelo.Aficion;
import com.mycompany.persistencia.modelo.Persona;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author iconotc
 */
public class Principal {

    private static final String CONSULTA_FETCH = "select distinct p from Persona p left join fetch p.aficiones";
    private static final String CONSULTA = "select p from Persona p";
    private static final String UNIT = "EjemploPU";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        try {
            EntityManagerFactory emf = principal.inicializarJpa(UNIT);
            Persona p = principal.construirPersona();
            Long clave = principal.insertar(emf, p);
            System.out.println("SIN USAR JOIN FETCH");
            String resultado = principal.consulta(emf, CONSULTA);
            System.out.println(resultado);
            System.out.println("USANDO JOIN FETCH");
            resultado = principal.consulta(emf, CONSULTA_FETCH);
            System.out.println(resultado);
            emf.close();
            System.out.println("Fin");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e);
        }
    }

    private Persona construirPersona() {
        Persona p = new Persona("Juan");
        Aficion a1 = new Aficion("fútbol");
        Aficion a2 = new Aficion("Tenis");
        p.getAficiones().add(a1);
        p.getAficiones().add(a2);
        a1.setPersona(p);
        a2.setPersona(p);
        return p;
    }

    private Long insertar(EntityManagerFactory emf, Persona p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        return p.getId();
    }

    private String consulta(EntityManagerFactory emf, String texto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Persona> r = em.createQuery(texto).getResultList();
        em.getTransaction().commit();
        em.close();
        return r.stream().map(Persona::toString).collect(Collectors.joining("\n"));
    }

    private EntityManagerFactory inicializarJpa(String unit) {
        return Persistence.createEntityManagerFactory(unit);
    }

}
