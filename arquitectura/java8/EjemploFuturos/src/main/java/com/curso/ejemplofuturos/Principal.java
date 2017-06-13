/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemplofuturos;

import com.curso.ejemplofuturos.autenticacion.ProxyAuthenticator;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.*;
import java.net.Authenticator;
import java.net.URISyntaxException;
import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author usuario
 */
public class Principal {

    private static final Logger LOG = Logger.getLogger(Principal.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Principal p = new Principal();
            p.inicializarProxy();
            final URL url = new URL("http://www.google.es");
            Future<String> contenidoAsync = p.descargarContenidoAsync(url);
            out.println("La llamada asíncrona retorna de inmediato");
            String contenido = p.descargarContenido(url);
            out.println("Acaba de finalizar la llamada síncrona");
            while (!contenidoAsync.isDone()) {
                out.println("La llamada asíncrona no ha finalizado su trabajo");
            }
            out.println("La llamada asíncrona ha finalizado su trabajo y ha leído " + contenidoAsync.get().length() + " caracteres");
            System.out.println("La llamada síncrona leyó " + contenido.length() + " caracteres");
            p.pool.shutdown();
            while (!p.pool.isTerminated());
            out.println("Fin");
        } catch (IOException | InterruptedException | ExecutionException | URISyntaxException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    private String descargarContenido(URL url) throws IOException, URISyntaxException {
        try (InputStream input = url.openStream()) {
            return IOUtils.toString(input, StandardCharsets.UTF_8);
        }
    }

    private final ExecutorService pool = Executors.newFixedThreadPool(10);

    private Future<String> descargarContenidoAsync(URL url) throws IOException {
        return pool.submit(() -> descargarContenido(url));
    }

    private void inicializarProxy() {
        Authenticator.setDefault(new ProxyAuthenticator("usuario", "clave"));
        System.setProperty("http.proxyHost", "proxy.indra.es");
        System.setProperty("http.proxyPort", "8080");
    }
}
