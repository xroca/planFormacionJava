/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.saajservermvn;

import javax.xml.ws.Endpoint;
import com.curso.endpoint.SaludoImpl;

/**
 *
 * @author usuario
 */
public class SaajServerMvn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/WebServiceDemo/Saludo", new SaludoImpl());
        System.out.println("Servidor arrancado");
    }

}
