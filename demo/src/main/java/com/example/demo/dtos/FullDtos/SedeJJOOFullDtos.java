package com.example.demo.dtos.FullDtos;

public class SedeJJOOFullDtos {

    private Integer año;
    private Integer idTipoJJOO;
    private CiudadFullDtos ciudad;

    public SedeJJOOFullDtos(Integer año, Integer idTipoJJOO, CiudadFullDtos ciudad) {
        this.año = año;
        this.idTipoJJOO = idTipoJJOO;
        this.ciudad = ciudad;
    }

    public SedeJJOOFullDtos() {
    }

    public Integer getAño() {
        return año;
    }

    public Integer getIdTipoJJOO() {
        return idTipoJJOO;
    }

    public CiudadFullDtos getCiudad() {
        return ciudad;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public void setIdTipoJJOO(Integer idTipoJJOO) {
        this.idTipoJJOO = idTipoJJOO;
    }

    public void setCiudad(CiudadFullDtos ciudad) {
        this.ciudad = ciudad;
    }
}
