package com.cristian.Peliculas.pelicula.infrastructure;

import com.cristian.Peliculas.DBConnection;
import com.cristian.Peliculas.pelicula.domain.Pelicula;
import com.cristian.Peliculas.pelicula.domain.PeliculaRepository;
import com.cristian.Peliculas.usuario.domain.Usuario;
import com.cristian.Peliculas.usuario.domain.UsuarioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeliculaUseCasesMysql implements PeliculaRepository {

    @Override
    public List<Pelicula> getAll(Integer id) {
       List<Pelicula> peliculas = new ArrayList<>();
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            String query="select * from pelicula where id_usuario="+id;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("Duracion"),
                        rs.getInt("id_usuario")
                );
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return peliculas;
    }

    @Override
    public List<Pelicula> savePelicula(Integer id,Pelicula pelicula) {

        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("insert into pelicula (id,titulo,Duracion,id_usuario) values (NULL,?,?,?)");
            statement.setString(1,pelicula.getTitulo());
            statement.setString(2,pelicula.getDuracion());
            statement.setInt(3,id);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        List<Pelicula> peliculas=getAll(id);
        return peliculas;
    }

    @Override
    public Pelicula updatePelicula(Integer id, String nombre, Pelicula pelicula) {
        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("update pelicula set duracion=? where titulo=? and id_usuario=?");
            statement.setString(1,pelicula.getDuracion());
            statement.setString(2,nombre);
            statement.setInt(3,id);
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        try {
            Statement statement = DBConnection.getInstance().createStatement();
            String query="select * from pelicula where id_usuario="+id+" and titulo='"+nombre+"'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                 pelicula = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("Duracion"),
                        rs.getInt("id_usuario")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pelicula;
    }

    @Override
    public List<Pelicula> deletePelicula(Integer id, String nombre) {
        try {
            PreparedStatement statement=DBConnection.getInstance().prepareStatement("delete from pelicula where id_usuario="+id+" and titulo='"+nombre+"'");
            statement.execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        List<Pelicula> peliculas = getAll(id);
        return peliculas;
    }
}
