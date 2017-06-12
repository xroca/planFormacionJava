
import com.mycompany.ejemplorestunoclient.client.NewJerseyClient;
import com.mycompany.ejemplorestunoclient.client.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        
        
        NewJerseyClient njc = new NewJerseyClient();
        njc.putXml(new Persona(100000L,"Xavier"));
        
        Persona p = njc.getXml(Persona.class);
        
        
        
        System.out.println(p);
        
        
        
        
        
        
        
     
        
        
        
        
    }
    
}
