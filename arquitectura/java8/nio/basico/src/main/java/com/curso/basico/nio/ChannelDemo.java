/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.basico.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class ChannelDemo {

    private static final String fileInput = "texto";
    private static final String fileOutput = "otro";

    public void noEjecutar() throws FileNotFoundException {
        FileInputStream is = new FileInputStream(fileInput);
        FileChannel fchLectura = is.getChannel();
        FileOutputStream os = new FileOutputStream(fileInput);
        FileChannel fchEscritura = is.getChannel();
        ReadableByteChannel rdb = Channels.newChannel(getClass().getClassLoader().getResourceAsStream(fileInput));
        WritableByteChannel wtb = Channels.newChannel(os);
    }

    public static void leerArchivo() {
        FileChannel fileChannel = null;
        try {
            fileChannel = new FileInputStream(fileInput).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                buffer.clear();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println();
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException ex) {
                    Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void escribirArchivo() {
        FileChannel f = null;
        try {
            f = new FileOutputStream(fileOutput).getChannel();
            final String texto = "abcdef";
            byte[] bytes = texto.getBytes("UTF-8");
            ByteBuffer b = ByteBuffer.wrap(bytes);
            f.write(b);
            System.out.println("Texto escrito en " + new File(fileOutput).getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException ex) {
                    Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void mapMemoria() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileInput);
            FileChannel fc = fis.getChannel();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            while (mbb.hasRemaining()) {
                System.out.print((char) mbb.get());
            }
            fc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println();
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void copiar() {
        try {
            File origen = new File(fileInput);
            File destino = new File(fileOutput);
            copy(origen, destino, true);
            System.out.println(origen.getAbsoluteFile()
                    + " se ha copiado a "
                    + destino.getAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(ChannelDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void copy(File origen, File destino, boolean sobreEscribir) throws IOException {
        String msg = null;
        if (!origen.exists()) {
            msg = "El origen " + origen.getAbsolutePath()
                    + " no existe.";
            throw new IOException(msg);
        }
        if (destino.exists() && !sobreEscribir) {
            msg = "El destino "
                    + destino.getAbsolutePath()
                    + " ya existe.";
            throw new IOException(msg);
        }
        try (FileChannel canalOrigen
                = new FileInputStream(origen).getChannel();
                FileChannel canalDestino
                = new FileOutputStream(destino).getChannel()) {
            canalOrigen.transferTo(0, canalOrigen.size(), canalDestino);
        }
    }
}
