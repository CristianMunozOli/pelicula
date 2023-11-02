package com.cristian.Peliculas.usuario.aplication;

import com.cristian.Peliculas.usuario.domain.Usuario;
import com.cristian.Peliculas.usuario.domain.UsuarioRepository;

import java.util.List;

public class UsuarioUseCases {
    private final UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> getAll(){ return this.usuarioRepository.getAll();}
}
