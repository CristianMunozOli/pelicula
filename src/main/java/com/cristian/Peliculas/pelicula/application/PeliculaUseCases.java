package com.cristian.Peliculas.pelicula.application;

import com.cristian.Peliculas.pelicula.domain.Pelicula;
import com.cristian.Peliculas.pelicula.domain.PeliculaRepository;

import java.util.List;

public class PeliculaUseCases {
        private final PeliculaRepository peliculaRepository;

    public PeliculaUseCases(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }
    public List<Pelicula> getAll(Integer id){ return this.peliculaRepository.getAll(id);}
    public List<Pelicula> savePelicula(Integer id,Pelicula pelicula){ return this.peliculaRepository.savePelicula(id,pelicula);}
    public Pelicula updatePelicula(Integer id, String nombre,Pelicula pelicula){ return this.peliculaRepository.updatePelicula(id,nombre,pelicula);}
    public List<Pelicula> deletePelicula(Integer id, String nombre){ return this.peliculaRepository.deletePelicula(id,nombre);}
}
