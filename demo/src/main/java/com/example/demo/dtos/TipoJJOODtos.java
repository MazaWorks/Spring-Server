package com.example.demo.dtos;

public class TipoJJOODtos {

    private int idTipoJJOO;
    private String descripcionTipo;

    public TipoJJOODtos(int idTipoJJOO, String descripcionTipo) {
        this.idTipoJJOO = idTipoJJOO;
        this.descripcionTipo = descripcionTipo;
    }

    public int getIdTipoJJOO() {
        return idTipoJJOO;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setIdTipoJJOO(int idTipoJJOO) {
        this.idTipoJJOO = idTipoJJOO;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
}
