package com.example.demo.daos;

import com.example.demo.dtos.Consulta1Dtos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOConsulta {

    private String dbUrl = "jdbc:mysql://localhost:3306/juegosolimpicos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String dbUser = "root";
    private String dbPass = "Qindel1234";

    public List<Consulta1Dtos> get() {
        List<Consulta1Dtos> list = new ArrayList<>();
        String toret = "";
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement statement = connection.prepareStatement("SELECT P.id_pais, P.nombre_pais, C.id_ciudad, C.nombre_ciudad, IFNULL(C.valor_ciudad,P.valor_pais) AS valor,\n" +
                             "CASE\n" +
                             "    WHEN C.id_ciudad = S.sede THEN T.descripcion_tipo\n" +
                             "    ELSE \"NULL\"\n" +
                             "END as descripcion_tipo, count(DISTINCT S.año) as veces_sede\n" +
                             "FROM Pais P, Tipo_jjoo T, Ciudad C \n" +
                             "LEFT JOIN Sede_jjoo S ON C.id_ciudad = S.sede\n" +
                             "WHERE P.id_pais = C.id_pais \n" +
                             "group by C.id_ciudad")) {
            try (ResultSet result = statement.executeQuery()) {
                int idPais, idCiudad, valor, vecesSedes;
                String nombrePais, nombreCiudad, descripcionTipo;
                while (result.next()) {
                    idPais = result.getInt(1);
                    nombrePais = result.getString(2);
                    idCiudad = result.getInt(3);
                    nombreCiudad = result.getString(4);
                    valor = result.getInt(5);
                    descripcionTipo = result.getString(6);
                    vecesSedes = result.getInt(7);

                    Consulta1Dtos x = new Consulta1Dtos(idPais, nombrePais, idCiudad, nombreCiudad, valor, descripcionTipo, vecesSedes);
                    list.add(x);
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
