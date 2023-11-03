package com.cristian.Peliculas.usuario.domain;

public class Usuario {
    private Integer id;
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }
}
