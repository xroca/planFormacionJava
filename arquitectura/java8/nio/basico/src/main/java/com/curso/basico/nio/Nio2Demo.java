/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.basico.nio;

import java.io.IOException;
import static java.lang.System.out;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author usuario
 */
public class Nio2Demo {

    private static final String FILEINPUT = "texto";
    private static final String FILEOUTPUT = "otro";
    private static final String TESTFILE = "test.txt";

    public static void fileSystems() {
        FileSystem fs = FileSystems.getDefault();
        System.out.println("Solo lectura: " + fs.isReadOnly());
        System.out.println("Separador: " + fs.getSeparator());
        System.out.println("\nFileStores");
        fs.getFileStores().forEach(Nio2Demo::detalle);
        System.out.println("\nUnidades");
        fs.getRootDirectories().forEach(out::println);
    }

    private static void detalle(FileStore store) {
        try {
            String desc = store.toString();
            String tipo = store.type();
            long espacioTotal = store.getTotalSpace();
            long espacioSinAsignar = store.getUnallocatedSpace();
            long espacioLibre = store.getUsableSpace();
            System.out.println(desc + ", Total: " + espacioTotal
                    + ", sin asignar: " + espacioSinAsignar
                    + ", Disponible: " + espacioLibre);
        } catch (IOException ex) {
            Logger.getLogger(Nio2Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void paths() {
        Path p = FileSystems.getDefault().getPath(FILEINPUT);
        System.out.println("Detalles del path: " + p);
        int contador = p.getNameCount();
        System.out.println("Elementos: " + contador);
        for (int i = 0; i < contador; i++) {
            Path nombre = p.getName(i);
            System.out.println("Nombre en posición " + i + " es " + nombre);
        }
        Path ancestro = p.getParent();
        Path raiz = p.getRoot();
        Path nombreArchivo = p.getFileName();
        System.out.println("Ancestro: " + ancestro + ", Raíz: " + raiz
                + ", Nombre del archivo: " + nombreArchivo);
        System.out.println("El path es absoluto: " + p.isAbsolute());
    }

    public static void crearArchivo() {
        Path p1 = Paths.get(TESTFILE);
        try {
            Files.createFile(p1);
            System.out.format("Archivo creado: %s%n", p1.toRealPath());
        } catch (FileAlreadyExistsException e) {
            System.out.format("El archivo %s ya existe.%n",
                    p1.normalize());
        } catch (NoSuchFileException ex) {
            System.out.format("El directorio %s no existe.%n",
                    p1.normalize().getParent());
        } catch (IOException ex) {
            Logger.getLogger(Nio2Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void borrarArchivo() {
        Path p = Paths.get(TESTFILE);
        try {
            Files.delete(p);
            System.out.println(p + " borrado.");
        } catch (NoSuchFileException e) {
            System.out.println(p + " not existe.");
        } catch (DirectoryNotEmptyException ex) {
            System.out.println("El directorio " + p + " no está vacío.");
        } catch (IOException ex) {
            Logger.getLogger(Nio2Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void leerContenido() {
        Charset cs = Charset.forName("UTF-8");
        Path origen = Paths.get(FILEINPUT);
        try {
//            List<String> lines = Files.readAllLines(source, StandardCharsets.UTF_8);
            List<String> lines = Files.readAllLines(origen, cs);
            lines.forEach(out::println);
        } catch (NoSuchFileException e) {
            System.out.println(origen.toAbsolutePath() + " no existe.");
        } catch (IOException ex) {
            Logger.getLogger(Nio2Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void leerContenidoLazy(String palabra) {
        Objects.requireNonNull(palabra, "La palabra buscada no puede set nula");
        try (Stream<String> s = Files.lines(Paths.get(FILEINPUT))) {
            String str = s.filter(linea -> linea.contains(palabra))
                    .onClose(() -> System.out.println("Archivo cerrado"))
                    .findFirst()
                    .map(linea -> "Esta línea \"" + linea + "\" contiene la palabra dos")
                    .orElse("La palabra \"" + palabra + "\" no se encuentra");
            System.out.println("Resultado de la búsqueda: " + str);
        } catch (IOException ex) {
            Logger.getLogger(Nio2Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escribirContenido() {
        List<String> texto = asList("seis", "siete", "ocho", "nueve", "diez");
        Path destino = Paths.get(FILEOUTPUT);        
        try {
            Path p = Files.write(destino, texto, StandardCharsets.UTF_8, WRITE, CREATE);
            System.out.println("Se ha escrito en " + p.toAbsolutePath());
        } catch (IOException ex) {
            Logger.getLogger(Nio2Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
