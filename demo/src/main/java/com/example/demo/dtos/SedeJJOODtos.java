package com.example.demo.dtos;

public class SedeJJOODtos {

    private int año;
    private int idTipoJJOO;
    private int sede;

    public SedeJJOODtos(int año, int idTipoJJOO, int sede) {
        this.año = año;
        this.idTipoJJOO = idTipoJJOO;
        this.sede = sede;
    }

    public int getSede() {
        return sede;
    }

    public int getAño() {
        return año;
    }

    public int getIdTipoJJOO() {
        return idTipoJJOO;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setIdTipoJJOO(int idTipoJJOO) {
        this.idTipoJJOO = idTipoJJOO;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }
}
