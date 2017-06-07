/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xrocal
 */
public class conDB {
    
    private static Connection con=null;
    
    public static Connection obrirConDB(){
    
    
        
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/curso", "app", "app");
        } catch (SQLException ex) {
            Logger.getLogger(conDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    return con;
    }
    
    
    public static void tancarConDB(Connection con){
    
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(conDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
