/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.apache.commons.lang3.RandomStringUtils.*;

/**
 *
 * @author xrocal
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner lector = new Scanner(System.in);

        int opcio;
        int id;
        String nom = "Aaaa";
        String pass = "kfjdkjfdslfk";

        System.out.println("Menú:");
        System.out.println("1. Crear usuario");
        System.out.println("2. Login");

        opcio = lector.nextInt();

        switch (opcio) {

            case 1:

                System.out.println("Introducir ID: ");
                
                id = lector.nextInt();
                
                System.out.println("Introducir Nombre: ");
                
                nom = lector.next();
                
                System.out.println("Introducir Contraseña: ");
                
                pass = lector.next();
                
                
                Usuario u = new Usuario(id,nom,pass); 
                
                FactoriaUsuarioDao.get().nueva(u);
                
                
//                Arrays.asList(random(16, false, true))
//                        .stream().map(s -> new Usuario(Long.parseLong(s), nom, pass))
//                        .forEach(usuario -> FactoriaUsuarioDao.get().nueva(usuario));
               
                break;

            case 2:

                List<Usuario> lista;
                
                 System.out.println(lista = FactoriaUsuarioDao.get().todos());
                 
                 
                 

                break;

            default:

                break;

        }

    }

}
