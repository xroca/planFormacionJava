/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prova_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xrocal
 */
public class Main {

    private static Connection con;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        ResultSet resultat;
        Integer id = 0;
        Scanner lector = new Scanner(System.in);
        String cadena;
        
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/curso", "app", "app");

            System.out.println("Connectado");

            Statement stat = con.createStatement();
            
            int opcio;
            
            
            
            System.out.println("1. Insertar");
            System.out.println("2. Modificar");
            System.out.println("3. Borrar");
            System.out.println("4. Mostrar");
            
            opcio = lector.nextInt();
            
            switch(opcio){
            
                case 1:
                      System.out.println("Nombre: ");
                      cadena = lector.next();                      
                      stat.execute("INSERT INTO personas (id,nombre) values ("+id+",'"+cadena+"')");               
                    break;
                case 2:
                    break;
                case 3:
                    
                         stat.execute("DELETE FROM personas where id=0");
                    
                    break;
                case 4:
                    break;
                
            
            }
            
            

            
            
            //stat.execute("INSERT INTO personas (id, nombre) values ("+id+",'Xavier')");
            //stat.execute("UPDATE personas SET nombre = 'Roca' WHERE id=1");
            
           //SELECT * FROM personas where rownum=1 order by id desc

            resultat = stat.executeQuery("SELECT * FROM personas w");

            while (resultat.next()) {

                System.out.println("ID: " + resultat.getBigDecimal("id") + " Nombre: " + resultat.getString("nombre"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
        }

    }
    
    
    public int obtenirUltimaId(ResultSet rs, Statement stat, Connection con) throws SQLException{
    
            stat.executeQuery("SELECT distinct * from personas where order by  )");
        
            while (rs.next()) {

           
                

            }
        
    
        return 0;
        
    }
    
    

}
