/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplounocliente;

import com.mycompany.ejemplounocliente.ws.NewWebService;
import com.mycompany.ejemplounocliente.ws.NewWebService_Service;

/**
 *
 * @author xrocal
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        try { // Call Web Service Operation
           NewWebService_Service service = new NewWebService_Service();
            NewWebService port = service.getNewWebServicePort();
            // TODO initialize WS operation arguments here
            java.lang.String name = "Xavier";
            // TODO process result here
            java.lang.String result = port.hola(name);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

        
        
    }
    
}
