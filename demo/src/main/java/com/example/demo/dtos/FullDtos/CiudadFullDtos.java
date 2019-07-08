package com.example.demo.dtos.FullDtos;

public class CiudadFullDtos {

    private Integer idCiudad;
    private Integer valorCiudad;
    private String nombreCiudad;
    private PaisFullDtos pais;

    public CiudadFullDtos(Integer idCiudad, Integer valorCiudad, String nombreCiudad, PaisFullDtos pais) {
        this.idCiudad = idCiudad;
        this.valorCiudad = valorCiudad;
        this.nombreCiudad = nombreCiudad;
        this.pais = pais;
    }

    public CiudadFullDtos(Integer idCiudad, String nombreCiudad, PaisFullDtos pais) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.pais = pais;
    }

    public PaisFullDtos getPais() {
        return pais;
    }

    public CiudadFullDtos() {
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public Integer getValorCiudad() {
        return valorCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setPais(PaisFullDtos pais) {
        this.pais = pais;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }


    public void setValorCiudad(Integer valorCiudad) {
        this.valorCiudad = valorCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }
}
