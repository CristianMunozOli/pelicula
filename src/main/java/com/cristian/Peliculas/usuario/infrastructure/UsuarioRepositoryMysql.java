package com.cristian.Peliculas.usuario.infrastructure;

import com.cristian.Peliculas.DBConnection;
import com.cristian.Peliculas.usuario.domain.Usuario;
import com.cristian.Peliculas.usuario.domain.UsuarioRepository;

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
}
