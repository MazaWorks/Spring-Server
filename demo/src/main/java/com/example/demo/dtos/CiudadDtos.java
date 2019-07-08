package com.example.demo.dtos;

public class CiudadDtos {
    private Integer idCiudad;
    private int idPais;
    private int valorCiudad;
    private String nombreCiudad;

    public CiudadDtos(int idCiudad, int idPais, int valorCiudad, String nombreCiudad) {
        this.idCiudad = idCiudad;
        this.idPais = idPais;
        this.valorCiudad = valorCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public int getIdPais() {
        return idPais;
    }

    public int getValorCiudad() {
        return valorCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setValorCiudad(int valorCiudad) {
        this.valorCiudad = valorCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
