package com.cristian.Peliculas.usuario.infrastructure;

import com.cristian.Peliculas.DBConnection;
import com.cristian.Peliculas.usuario.domain.Usuario;
import com.cristian.Peliculas.usuario.domain.UsuarioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryMysql implements UsuarioRepository {
    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        Statement statement = null;
        try {
            statement = DBConnection.getInstance().createStatement();
            ResultSet rs = statement.executeQuery("select * from usuario");
            while (rs.next()){
                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
       return usuarios;
    }

    @Override
    public List<Usuario> saveUsuario(Usuario usuario) {
        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("INSERT INTO usuario (ID,Nombre) VALUES (NULL, ?)");
            statement.setString(1,usuario.getNombre());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Usuario> usuarios = getAll();
        return usuarios;
    }


    @Override
    public List<Usuario> deleteUsuario(Integer id) {
        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("delete from usuario where id="+id);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        List<Usuario> usuarios = getAll();
        return usuarios;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario,Integer id) {
        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("update usuario set nombre=? where id=?");
            statement.setString(1,usuario.getNombre());
            statement.setInt(2,id);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        Usuario usuarioModificado = new Usuario(usuario.getId(), usuario.getNombre());
        return usuarioModificado;
    }

}
