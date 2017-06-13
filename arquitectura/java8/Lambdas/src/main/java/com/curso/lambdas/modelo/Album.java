/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.modelo;

import java.util.List;

/**
 *
 * @author Chema
 */
public class Album {
    
    private String nombre;

    private List<Pista> pistas;

    private List<Artista> musicos;

    private Artista musicoPrincipal;

    /**
     * Get the value of musicoPrincipal
     *
     * @return the value of musicoPrincipal
     */
    public Artista getMusicoPrincipal() {
        return musicoPrincipal;
    }

    /**
     * Set the value of musicoPrincipal
     *
     * @param musicoPrincipal new value of musicoPrincipal
     */
    public void setMusicoPrincipal(Artista musicoPrincipal) {
        this.musicoPrincipal = musicoPrincipal;
    }

    /**
     * Get the value of musicos
     *
     * @return the value of musicos
     */
    public List<Artista> getMusicos() {
        return musicos;
    }

    /**
     * Set the value of musicos
     *
     * @param musicos new value of musicos
     */
    public void setMusicos(List<Artista> musicos) {
        this.musicos = musicos;
    }

    /**
     * Get the value of pistas
     *
     * @return the value of pistas
     */
    public List<Pista> getPistas() {
        return pistas;
    }

    /**
     * Set the value of pistas
     *
     * @param pistas new value of pistas
     */
    public void setPistas(List<Pista> pistas) {
        this.pistas = pistas;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
