/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploasynctemplate0001;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import static java.util.Arrays.asList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

/**
 *
 * @author usuario
 */
public class EjemploAsyncRestTemplate0001 {

    private static final Logger LOG = Logger.getLogger(EjemploAsyncRestTemplate0001.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String... args) {
        if (asList(args).stream().anyMatch(argumento -> argumento.equalsIgnoreCase("proxy"))) {
            configurarProxy("usuario", "clave");
        }
        AsyncRestTemplate async = new AsyncRestTemplate();
        String url = "http://google.com";
        HttpMethod metodo = HttpMethod.GET;
        Class<String> tipoRespuesta = String.class;
        HttpHeaders cabeceras = new HttpHeaders();
        cabeceras.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> peticion = new HttpEntity<>("params", cabeceras);
        ListenableFuture<ResponseEntity<String>> future = async.exchange(url, metodo, peticion, tipoRespuesta);
        try {
            ResponseEntity<String> resultado = future.get();
            LOG.log(Level.INFO, resultado.getBody());
        } catch (InterruptedException | ExecutionException e) {
            LOG.log(Level.SEVERE, () -> e.toString());
        }
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
