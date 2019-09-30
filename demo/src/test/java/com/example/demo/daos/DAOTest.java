package com.example.demo.daos;

import com.example.demo.dtos.Consulta1Dtos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DAOTest {

    private DAOConsulta daoConsulta;
    private List<Consulta1Dtos> resultFine = new ArrayList<>();

    @BeforeEach
    void setUp() {
        daoConsulta = new DAOConsulta();
        resultFine.add(new Consulta1Dtos(1, "ESPAÑA", 1, "LA CORUÑA", 93, "NULL", 0));
        resultFine.add(new Consulta1Dtos(1, "ESPAÑA", 2, "MADRID", 100, "NULL", 0));
        resultFine.add(new Consulta1Dtos(1, "ESPAÑA", 3, "BARCELONA", 124, "INVIERNO", 1));
        resultFine.add(new Consulta1Dtos(2, "PORTUGAL", 4, "LISBOA", 134, "NULL", 0));
        resultFine.add(new Consulta1Dtos(2, "PORTUGAL", 5, "OPORTO", 200, "NULL", 0));
        resultFine.add(new Consulta1Dtos(2, "PORTUGAL", 6, "COIMBRA", 200, "NULL", 0));
        resultFine.add(new Consulta1Dtos(3, "FRANCIA", 7, "CHAMONIX", 123, "INVIERNO", 1));
        resultFine.add(new Consulta1Dtos(3, "FRANCIA", 8, "PARÍS", 5, "VERANO", 2));
        resultFine.add(new Consulta1Dtos(3, "FRANCIA", 9, "NIZA", 50, "NULL", 0));
        resultFine.add(new Consulta1Dtos(4, "ITALIA", 10, "MILÁN", 135, "NULL", 0));
        resultFine.add(new Consulta1Dtos(4, "ITALIA", 11, "ROMA", 125, "INVIERNO", 1));
        resultFine.add(new Consulta1Dtos(4, "ITALIA", 12, "TURÍN", 190, "VERANO", 1));
    }

    @Test
    void get() {
        List<Consulta1Dtos> resultReal = daoConsulta.get();
        int x = 0;
        while(x < resultFine.size()) {
            assertEquals(resultReal.get(x).getDescripcionTipo(), resultFine.get(x).getDescripcionTipo());
            assertEquals(resultReal.get(x).getIdCiudad(), resultFine.get(x).getIdCiudad());
            assertEquals(resultReal.get(x).getIdPais(), resultFine.get(x).getIdPais());
            assertEquals(resultReal.get(x).getNombreCiudad(), resultFine.get(x).getNombreCiudad());
            assertEquals(resultReal.get(x).getNombrePais(), resultFine.get(x).getNombrePais());
            assertEquals(resultReal.get(x).getValor(), resultFine.get(x).getValor());
            assertEquals(resultReal.get(x).getVecesSedes(), resultFine.get(x).getVecesSedes());
            x++;
        }
    }
}