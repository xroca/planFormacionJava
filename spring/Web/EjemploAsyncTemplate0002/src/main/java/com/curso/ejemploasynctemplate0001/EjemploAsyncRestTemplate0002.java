/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploasynctemplate0001;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import static java.util.Arrays.asList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

/**
 *
 * @author usuario
 */
public class EjemploAsyncRestTemplate0002 {

    private static final Logger LOG = Logger.getLogger(EjemploAsyncRestTemplate0002.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        if (asList(args).stream().anyMatch(argumento -> argumento.equalsIgnoreCase("proxy"))) {
            configurarProxy("usuario", "clave");
        }        
        AsyncRestTemplate async = new AsyncRestTemplate();
        String url = "http://google.com";
        ListenableFuture<ResponseEntity<String>> resultadoFuturo = async.getForEntity(url, String.class);
        resultadoFuturo.addCallback(
                r -> LOG.log(Level.INFO, r.getBody()),
                e -> LOG.log(Level.SEVERE, e.toString())
        );
//        resultadoFuturo.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
//
//            @Override
//            public void onSuccess(ResponseEntity<String> result) {
//                LOG.log(Level.INFO, result.getBody());
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                LOG.log(Level.SEVERE, () -> ex.toString());
//            }
//        });
        LOG.log(Level.INFO, "Fin");
    }

    private static void configurarProxy(String usuario, String clave) {
        System.out.println("Configurando el proxy");
        System.setProperty("proxySet", "true");
        System.setProperty("http.proxyHost", "proxy.indra.es");
        System.setProperty("http.proxyPort", "8080");
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave.toCharArray());
            }
        });
    }
}
