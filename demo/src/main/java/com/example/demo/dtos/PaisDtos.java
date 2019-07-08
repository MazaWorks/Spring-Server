package com.example.demo.dtos;

public class PaisDtos {
    private int idPais;
    private int valorPais;
    private String nombrePais;
    private String codigoPais;

    public PaisDtos(int valorPais, int idPais, String nombrePais, String codigoPais) {
        this.valorPais = valorPais;
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.codigoPais = codigoPais;
    }

    public int getValorPais() {
        return valorPais;
    }

    public int getIdPais() {
        return idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setValorPais(int valorPais) {
        this.valorPais = valorPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }
}
