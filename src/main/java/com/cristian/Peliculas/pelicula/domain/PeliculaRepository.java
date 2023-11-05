package com.cristian.Peliculas.pelicula.domain;

import java.util.List;

public interface PeliculaRepository {
    public List<Pelicula> getAll(Integer id);
    public List<Pelicula> savePelicula(Integer id,Pelicula pelicula);
    public  Pelicula updatePelicula(Integer id, String nombre, Pelicula pelicula);
    public  List<Pelicula> deletePelicula(Integer id, String nombre);
}
