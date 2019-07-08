package com.example.demo.daos.mysql;

import com.example.demo.dtos.TipoJJOODtos;
import com.example.demo.entities.TipoJJOO;

import java.sql.*;

public class DAOTipoJJOO {

    private String dbUrl = "jdbc:mysql://localhost:3306/juegosolimpicos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String dbUser = "root";
    private String dbPass = "root";

    public void create(int id_tipo_jjoo, String descripcion_tipo) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO tipo_jjoo (id_tipo_jjoo, descripcion_tipo) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id_tipo_jjoo);
            statement.setString(2, descripcion_tipo);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error insertando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id_tipo_jjoo, String descripcion_tipo) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("UPDATE sede_jjoo SET descripcion_tipo = ? WHERE id_tipo_jjoo = ?")) {
            statement.setInt(2, id_tipo_jjoo);
            statement.setString(1, descripcion_tipo);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error actualizando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id_tipo_jjoo){
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM sede_jjoo WHERE id_tipo_jjoo = ?")) {
            statement.setInt(1, id_tipo_jjoo);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error eliminando la pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TipoJJOODtos get(int id_tipo_jjoo){
        TipoJJOODtos toret = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM sede_jjoo WHERE id_tipo_jjoo = ?")) {
            statement.setInt(1, id_tipo_jjoo);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    String descripcion_tipo = result.getString("descripcion_tipo");
                    toret = new TipoJJOODtos(id_tipo_jjoo, descripcion_tipo);
                } else {
                    throw new SQLException("Error obteniendo la pagina");
                }
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toret;
    }
}
