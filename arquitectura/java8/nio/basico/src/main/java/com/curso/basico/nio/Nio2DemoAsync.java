/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.basico.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author usuario
 */
public class Nio2DemoAsync {

    private static final String FILEOUTPUT1 = "otro1";
    private static final String FILEOUTPUT2 = "otro2";

    public static void escribirContenidoAsyncConFuturos() {
        Path path = Paths.get(FILEOUTPUT1);
        try (AsynchronousFileChannel afc = AsynchronousFileChannel.open(path, WRITE, CREATE)) {
            List<Future<Integer>> l
                    = BufferDemo.crear().map(bb -> afc.write(bb, 0)).collect(toList());
            Future<Integer> f = l.get(0);
            System.out.println("Se han escrito " + f.get(1L, TimeUnit.SECONDS) + " bytes");
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException ex) {
            Logger.getLogger(Nio2DemoAsync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static ByteBuffer datos() {
        StringBuilder sb = new StringBuilder();
        asList("uno", "dos", "tres", "cuatro", "cinco").forEach(sb::append);
        return ByteBuffer.wrap(sb.toString().getBytes(StandardCharsets.UTF_8));
    }

    private static class Adjunto {

        public Path path;
        public ByteBuffer buffer;
        public AsynchronousFileChannel asyncChannel;
    }

    private static class ManejadorEscritura implements CompletionHandler<Integer, Adjunto> {

        @Override
        public void completed(Integer resultado, Adjunto adjunto) {
            System.out.format("%s bytes escritos en %s%n",
                    resultado, adjunto.path.toAbsolutePath());
            try {
                adjunto.asyncChannel.close();
            } catch (IOException ex) {
                Logger.getLogger(Nio2DemoAsync.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void failed(Throwable e, Adjunto adjunto) {
            System.out.format("La operación de escritura en el archivo %s ha fallado."
                    + " El error es: %s%n",
                    adjunto.path, e.getMessage());
            try {
                adjunto.asyncChannel.close();
            } catch (IOException ex) {
                Logger.getLogger(Nio2DemoAsync.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void escribirContenidoConHandler() {
        try {
            Path path = Paths.get(FILEOUTPUT2);
            AsynchronousFileChannel afc = AsynchronousFileChannel.open(path, WRITE, CREATE);
            ManejadorEscritura handler = new ManejadorEscritura();
            ByteBuffer dataBuffer = datos();
            Adjunto adjunto = new Adjunto();
            adjunto.asyncChannel = afc;
            adjunto.buffer = dataBuffer;
            adjunto.path = path;
            afc.write(dataBuffer, 0, adjunto, handler);
            try {
                System.out.println("Esperando 5 segundos...");
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Nio2DemoAsync.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Listo...");
        } catch (IOException ex) {
            Logger.getLogger(Nio2DemoAsync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
