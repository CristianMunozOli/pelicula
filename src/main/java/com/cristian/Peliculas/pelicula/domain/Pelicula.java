package com.cristian.Peliculas.pelicula.domain;

public class Pelicula {
    Integer id,id_usuario;
    String titulo,duracion;

    public Pelicula() {}

    public Pelicula(String titulo, String duracion, Integer id_usuario) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.id_usuario=id_usuario;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public Pelicula(Integer id, String titulo, String duracion, Integer id_usuario) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.id_usuario=id_usuario;
    }
}
