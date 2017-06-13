/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.lambdas.streams;

import com.curso.lambdas.modelo.Album;
import com.curso.lambdas.modelo.Artista;
import com.curso.lambdas.modelo.Pista;
import static com.curso.lambdas.utilidades.Util.*;
import static java.util.Arrays.asList;
import java.util.Comparator;
import static java.util.Comparator.comparing;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

/**
 *
 * @author Chema
 */
public class Consultas {

    public Long numeroDeArtistasDeUnaCiudad(String ciudad) {
        return todosLosArtistas()
                .stream()
                .filter(artista -> artista.esDe(ciudad))
                .count();
    }

    public Pista laPistaMasCorta() {
        return pistas().stream()
                .min(Comparator.comparing(pista -> pista.getLongitud()))
                .orElse(new Pista("No existe", -1));
    }

    public Set<String> ciudadesDeUnAlbum(Album album) {
        return album.getMusicos().stream()
                .filter(artista -> artista.getNombre().startsWith("The"))
                .map(artist -> artist.getOrigen())
                .collect(toSet());
    }

    public Pista laPistaMasCortaMr() {
        return pistas().stream()
                .min(Comparator.comparing(Pista::getLongitud))
                .orElse(new Pista("No existe", -1));
    }

    public Optional<Artista> grupoMayor(Stream<Artista> artists) {
        Function<Artista, Integer> getContador = artista -> artista.getMiembros().size();
        return artists.collect(maxBy(comparing(getContador)));
    }

    public double numeroMedioDePistas(List<Album> albums) {
        return albums.stream()
                .collect(averagingInt(album -> album.getPistas().size()));
    }

    public Map<Boolean, List<Artista>> artistasSinBanda(Stream<Artista> artistas) {
        return artistas.collect(partitioningBy(artista -> artista.estaSolo()));
    }

    public Map<Boolean, List<Artista>> artistasSinBandaMr(Stream<Artista> artistas) {
        return artistas.collect(partitioningBy(Artista::estaSolo));
    }

    public Map<Artista, List<Album>> albumsPorArtista(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMusicoPrincipal()));
    }

    public Map<Artista, Integer> contarAlbums() {
        Map<Artista, Integer> resultado = new HashMap<>();
        albumsPorArtista(todosLosAlbums().stream()).forEach((artist, albums) -> {
            resultado.put(artist, albums.size());
        });
        return resultado;
    }

    private final Map<String, Artista> cache = new HashMap<>();

    private Artista obtenerArtistaDeUnaFuentaDeDatosExterna(String nombre) {
        return new Artista();
    }

    public Artista get(String nombre) {
        return cache.computeIfAbsent(nombre, this::obtenerArtistaDeUnaFuentaDeDatosExterna);
    }

    public String artistasConFormato() {
        return todosLosArtistas().stream()
                .map(Artista::getNombre)
                .collect(joining(", ", "[", "]"));
    }

    public Map<Artista, Long> numeroDeAlbumsPorArtista(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMusicoPrincipal(),
                counting()));
    }

    public Map<Artista, List<String>> nombresDeAlbumPorArtista(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMusicoPrincipal,
                mapping(Album::getNombre, toList())));
    }

    public List<String> ejemploCollect1() {
        return Stream.of("a", "b", "c").collect(toList());
    }

    public Set<String> ejemploCollect2() {
        return Stream.of("a", "b", "c").collect(toCollection(TreeSet::new));
    }

    public List<String> ejemploMap() {
        return Stream.of("a", "b", "hola")
                .map(palabra -> palabra.toUpperCase())
                .collect(toList());
    }

    public List<String> ejemploMapMr() {
        return Stream.of("a", "b", "hola")
                .map(String::toUpperCase)
                .collect(toList());
    }

    public List<String> ejemploFilter() {
        return Stream.of("a", "1abc", "abc1")
                .filter(palabra -> Character.isDigit(palabra.charAt(0)))
                .collect(toList());
    }

    public List<Integer> ejemploFlatMap() {
        return Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numeros -> numeros.stream())
                .collect(toList());
    }

    public List<Integer> ejemploFlatMapMr() {
        return Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(List::stream)
                .collect(toList());
    }

    public Integer ejemploReduce1() {
        return Stream.of(1, 2, 3).reduce(0, (acc, elem) -> acc + elem);
    }

    public Integer ejemploReduceMr() {
        return Stream.of(1, 2, 3).reduce(0, Integer::sum);
    }

    public void mostrarEstadisticasLongitudPistas(Album album) {
        IntSummaryStatistics estadisticas
                = album.getPistas().stream()
                .mapToInt(pista -> pista.getLongitud())
                .summaryStatistics();
        System.out.printf("Max: %d, Min: %d, Media: %f, Suma: %d",
                estadisticas.getMax(),
                estadisticas.getMin(),
                estadisticas.getAverage(),
                estadisticas.getSum());
    }
}
