package com.example.demo.daos.mysql;

import com.example.demo.dtos.SedeJJOODtos;
import com.example.demo.entities.SedeJJOO;

import java.sql.*;

public class DAOSedeJJOO {

    private String dbUrl = "jdbc:mysql://localhost:3306/juegosolimpicos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String dbUser = "root";
    private String dbPass = "root";

    public void create(int año, int id_tipo_jjoo, int sede) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO sede_jjoo (año, id_tipo_jjoo, sede) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, año);
            statement.setInt(2, id_tipo_jjoo);
            statement.setInt(3, sede);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error insertando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int año, int id_tipo_jjoo, int sede) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("UPDATE sede_jjoo SET id_tipo_jjoo = ?, sede = ? WHERE año = ?")) {
            statement.setInt(1, id_tipo_jjoo);
            statement.setInt(2, sede);
            statement.setInt(3, año);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error actualizando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int año){
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM sede_jjoo WHERE año = ?")) {
            statement.setInt(1, año);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error eliminando la pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SedeJJOODtos get(int año){
        SedeJJOODtos toret = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM sede_jjoo WHERE año = ?")) {
            statement.setInt(1, año);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    int id_tipo_jjoo = result.getInt("id_tipo_jjoo");
                    int sede = result.getInt("sede");
                    toret = new SedeJJOODtos(año, id_tipo_jjoo, sede);
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
