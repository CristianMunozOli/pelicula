package com.cristian.Peliculas.usuario.domain;

import java.util.List;

public interface UsuarioRepository {
    public List<Usuario> getAll();
    public List<Usuario> saveUsuario(Usuario usuario);
    public Usuario updateUsuario(Usuario usuario,Integer id);
    public List<Usuario> deleteUsuario(Integer id);
}
