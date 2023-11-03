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
        assertEquals(2,usuarios.size());
    }
    @Test
    void saveUsuario(){
        this.usuarioUseCases.saveUsuario(new Usuario("user1"));
        List<Usuario> usuarios = this.usuarioUseCases.getAll();
        assertEquals(2,usuarios.size());
    }
    @Test
    void deleteVideojuego(){
        this.usuarioUseCases.deleteUsuario(8);
        List<Usuario> usuarios = this.usuarioUseCases.getAll();
        assertEquals(1,usuarios.size());
    }

}
