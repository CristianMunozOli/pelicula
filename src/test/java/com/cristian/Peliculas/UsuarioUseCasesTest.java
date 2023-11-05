package com.cristian.Peliculas;

import com.cristian.Peliculas.usuario.aplication.UsuarioUseCases;
import com.cristian.Peliculas.usuario.domain.Usuario;
import com.cristian.Peliculas.usuario.infrastructure.UsuarioRepositoryMysql;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioUseCasesTest {
    UsuarioUseCases usuarioUseCases;
    public UsuarioUseCasesTest(){
        this.usuarioUseCases= new UsuarioUseCases(new UsuarioRepositoryMysql());
    }
    @Test
    void getAll(){
        List<Usuario> usuarios = this.usuarioUseCases.getAll();
        assertEquals(3,usuarios.size());
    }
    @Test
    void saveUsuario(){
        Usuario usuario = new Usuario("Usuario1");
        this.usuarioUseCases.saveUsuario(usuario);
        List<Usuario> usuarios = this.usuarioUseCases.getAll();
        assertEquals(4,usuarios.size());
    }

    @Test
    void deleteUsuario(){
      //Cambiar id_usuario por una id existente
        this.usuarioUseCases.deleteUsuario(1);
        List<Usuario> usuarios = this.usuarioUseCases.getAll();
        assertEquals(3,usuarios.size());
    }

}
