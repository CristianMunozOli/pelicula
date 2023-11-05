package com.cristian.Peliculas.usuario.infrastructure;

import com.cristian.Peliculas.usuario.aplication.UsuarioUseCases;
import com.cristian.Peliculas.usuario.domain.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {
    private UsuarioUseCases usuarioUseCases;
    public UsuarioRestController(){ this.usuarioUseCases=new UsuarioUseCases(new UsuarioRepositoryMysql());}
    @GetMapping("/usuarios")
    public List<Usuario> getAll(){
        List<Usuario> usuarios = this.usuarioUseCases.getAll();
        return usuarios;
    }
    @PostMapping(path ="/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> saveUsuario(@RequestBody Usuario usuario){
        this.usuarioUseCases.saveUsuario(usuario);
        List<Usuario> usuarios = this.usuarioUseCases.getAll();
        return usuarios;
    }
    @PutMapping(path ="/usuarios/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUsuario(@RequestBody Usuario usuario,@PathVariable Integer id){
        this.usuarioUseCases.updateUsuario(usuario,id);
    }
    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Integer id){
        this.usuarioUseCases.deleteUsuario(id);


    }
}
