package com.cristian.Peliculas;

import com.cristian.Peliculas.pelicula.application.PeliculaUseCases;
import com.cristian.Peliculas.pelicula.domain.Pelicula;
import com.cristian.Peliculas.pelicula.infrastructure.PeliculaUseCasesMysql;
import com.cristian.Peliculas.usuario.domain.Usuario;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeliculaUseCasesTest {
    PeliculaUseCases peliculaUseCases;

    public PeliculaUseCasesTest() {
        this.peliculaUseCases = new PeliculaUseCases(new PeliculaUseCasesMysql());
    }
    //PRESUPONEMOS EN TODOS LOS CASOS DE TEST QUE HAY UN USUARIO CON ID 32
    @Test
    void getAll(){
        List<Pelicula> peliculas=this.peliculaUseCases.getAll(32);
        assertEquals(0,peliculas.size());
    }
    @Test
    void savePelicula(){
        this.peliculaUseCases.savePelicula(32,new Pelicula ("pelicula 1","120",32));
        List<Pelicula> peliculas = this.peliculaUseCases.getAll(32);
        assertEquals(1,peliculas.size());
    }
    @Test
    void deleteVideojuego(){
        this.peliculaUseCases.deletePelicula(32,"pelicula 1");
        List<Pelicula> peliculas = this.peliculaUseCases.getAll(32);
        assertEquals(0,peliculas.size());
    }

}
