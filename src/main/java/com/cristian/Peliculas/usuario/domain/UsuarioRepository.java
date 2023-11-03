package com.cristian.Peliculas.usuario.domain;

import java.util.List;

public interface UsuarioRepository {
    public List<Usuario> getAll();
    public void saveUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario,Integer id);
    public void deleteUsuario(Integer id);
}
