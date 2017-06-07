/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_maven;

/**
 *
 * @author xrocal
 */
public class Campeon {

    private String nombre;
    private int hp;
    private int mp;

    private Campeon() {
    }

    private Campeon(String nombre, int hp, int mp) {
        this.nombre = nombre;
        this.hp = hp;
        this.mp = mp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }
    
    
    //Crear una instancia de la classe, pero ho fa null.   
    //
    private static Campeon unicaInstancia;

    
    
    //Comprovar que la instancia no estigui creada ja.
    public static Campeon elUnico(String nombre, int hp, int mp) {

        if (unicaInstancia == null) {
            unicaInstancia = new Campeon(nombre, hp, mp);
        } else {
            System.out.println("No se puede crear el objeto " + nombre + " porque ya existe un objeto de la clase SoyUnico");

        }
        return unicaInstancia;
    }

}
