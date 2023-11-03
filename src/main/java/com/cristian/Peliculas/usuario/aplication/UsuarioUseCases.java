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
    public void saveUsuario(Usuario usuario){ this.usuarioRepository.saveUsuario(usuario);}
    public void updateUsuario(Usuario usuario, Integer id){ this.usuarioRepository.updateUsuario(usuario,id);}
    public void deleteUsuario(Integer id){ this.usuarioRepository.deleteUsuario(id);}
}
