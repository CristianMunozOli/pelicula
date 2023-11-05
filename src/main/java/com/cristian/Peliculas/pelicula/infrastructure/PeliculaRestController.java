package com.cristian.Peliculas.pelicula.infrastructure;

import com.cristian.Peliculas.pelicula.application.PeliculaUseCases;
import com.cristian.Peliculas.pelicula.domain.Pelicula;
import com.cristian.Peliculas.usuario.domain.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PeliculaRestController {
    private PeliculaUseCases peliculaUseCases;

    public PeliculaRestController() {this.peliculaUseCases = new PeliculaUseCases(new PeliculaUseCasesMysql());
    }
    @GetMapping("/usuarios/{id}/peliculas")
    public List<Pelicula> getAll(@PathVariable Integer id){
        List<Pelicula> peliculas = this.peliculaUseCases.getAll(id);
        return peliculas;
    }
    @PostMapping(path ="/usuarios/{id}/peliculas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Pelicula> savePelicula(@PathVariable Integer id,@RequestBody Pelicula pelicula){
        this.peliculaUseCases.savePelicula(id,pelicula);
        List<Pelicula> peliculas = this.peliculaUseCases.getAll(id);
        return peliculas;
    }
    @PutMapping(path ="/usuarios/{id}/peliculas/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pelicula updateUsuario(@RequestBody Pelicula pelicula, @PathVariable Integer id, @PathVariable String nombre){
       Pelicula peliculaModificada = this.peliculaUseCases.updatePelicula(id,nombre,pelicula);
       return peliculaModificada;
    }
    @DeleteMapping("/usuarios/{id}/peliculas/{nombre}")
    public List<Pelicula> deleteUsuario(@PathVariable Integer id,@PathVariable String nombre){
        List<Pelicula> peliculas = this.peliculaUseCases.deletePelicula(id,nombre);
        return peliculas;
    }
}
