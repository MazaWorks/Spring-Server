package com.example.demo.daos.mysql;

import com.example.demo.dtos.PaisDtos;
import com.example.demo.entities.Pais;

import java.sql.*;

public class DAOPais {

    private String dbUrl = "jdbc:mysql://localhost:3306/juegosolimpicos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String dbUser = "root";
    private String dbPass = "root";

    public void create(int valor_pais, int id_pais, String nombre_pais, String codigo_pais) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO pais (valor_pais, id_pais, nombre_pais, codigo_pais) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, valor_pais);
            statement.setInt(2, id_pais);
            statement.setString(3, nombre_pais);
            statement.setString(4, codigo_pais);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error insertando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int valor_pais, int id_pais, String nombre_pais, String codigo_pais) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("UPDATE pais SET valor_pais = ?, nombre_pais = ?, codigo_pais = ? WHERE id_pais = ?")) {
            statement.setInt(1, valor_pais);
            statement.setInt(4, id_pais);
            statement.setString(2, nombre_pais);
            statement.setString(3, codigo_pais);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error actualizando pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id_pais){
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM pais WHERE id_pais = ?")) {
            statement.setInt(1, id_pais);

            if (statement.executeUpdate() != 1)
                throw new SQLException("Error eliminando la pagina");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PaisDtos get(int id_pais){
        PaisDtos toret = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM pais WHERE id_pais = ?")) {
            statement.setInt(1, id_pais);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    int valor_pais = result.getInt("valor_pais");
                    String nombre_pais = result.getString("nombre_pais");
                    String codigo_pais = result.getString("codigo_pais");

                    toret = new PaisDtos(valor_pais, id_pais, nombre_pais, codigo_pais);
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
