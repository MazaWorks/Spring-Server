package com.example.demo.dtos.FullDtos;

public class PaisFullDtos {
    private Integer idPais;
    private String nombrePais;
    private String codigoPais;
    private Integer valorPais;

    public PaisFullDtos(Integer idPais, String nombrePais, String codigoPais, Integer valorPais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.codigoPais = codigoPais;
        this.valorPais = valorPais;
    }

    public PaisFullDtos() {
    }

    public Integer getIdPais() {
        return idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public Integer getValorPais() {
        return valorPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public void setValorPais(Integer valorPais) {
        this.valorPais = valorPais;
    }
}
