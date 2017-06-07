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
public abstract class FactoriaUsuarioDao {
    
    private static final usuarioDao DAO = new bdArchivo();
    public static usuarioDao get(){
        return DAO;
    }
}
