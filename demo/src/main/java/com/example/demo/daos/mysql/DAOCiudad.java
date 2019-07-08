package com.example.demo.daos.mysql;

import com.example.demo.dtos.CiudadDtos;
import com.example.demo.entities.Ciudad;

import java.sql.*;

public class DAOCiudad {
    private String dbUrl = "jdbc:mysql://localhost:3306/juegosolimpicos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String dbUser = "root";
    private String dbPass = "root";

    public void create(int id_ciudad, int id_pais, int valor_ciudad, String nombre_ciudad) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO ciudad (id_ciudad, id_pais, valor_ciudad, nombre_ciudad) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, id_ciudad);
            statement.setInt(2, id_pais);
            statement.setInt(3, valor_ciudad);
            statement.setString(4, nombre_ciudad);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error insertando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id_ciudad, int id_pais, int valor_ciudad, String nombre_ciudad) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("UPDATE ciudad SET id_pais = ?, valor_ciudad = ?, nombre_ciudad = ? WHERE id_ciudad= ?")) {
            statement.setInt(4, id_ciudad);
            statement.setInt(1, id_pais);
            statement.setInt(2, valor_ciudad);
            statement.setString(3, nombre_ciudad);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error actualizando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id_ciudad){
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM ciudad WHERE id_ciudad= ?")) {
            statement.setInt(1, id_ciudad);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error eliminando la pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CiudadDtos get(int id_ciudad){
        CiudadDtos toret = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM ciudad WHERE id_ciudad= ?")) {
            statement.setInt(1, id_ciudad);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    int valor_ciudad = result.getInt("valor_ciudad");
                    int id_pais = result.getInt("id_pais");
                    String nombre_ciudad = result.getString("nombre_ciudad");

                    toret = new CiudadDtos(id_ciudad, id_pais, valor_ciudad, nombre_ciudad);
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
