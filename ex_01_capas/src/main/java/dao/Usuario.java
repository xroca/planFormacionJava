/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author xrocal
 */
public class Usuario {

    private int id;

    private String nombre;

    private String pass;
    
    
    public Usuario(int id, String nombre, String pass){
    
        
        this.id=id;
        this.nombre=nombre;
        this.pass=pass;
        
        
        
    }
    

    /**
     * Get the value of pass
     *
     * @return the value of pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Set the value of pass
     *
     * @param pass new value of pass
     */
    public void setPass(String pass) {
        this.pass = pass;
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

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", pass=" + pass + '}';
    }
    
    
    
    
    

}
