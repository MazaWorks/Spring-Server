package com.example.demo.dtos;

public class Consulta1Dtos {
    private Integer idPais;
    private String nombrePais;
    private Integer idCiudad;
    private String nombreCiudad;
    private Integer valor;
    private String descripcionTipo;
    private Integer vecesSedes;

    public Consulta1Dtos(int idPais, String nombrePais, int idCiudad, String nombreCiudad, int valor, String descripcionTipo, int vecesSedes) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.valor = valor;
        this.descripcionTipo = descripcionTipo;
        this.vecesSedes = vecesSedes;
    }

    public int getIdPais() {
        return idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public int getValor() {
        return valor;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public int getVecesSedes() {
        return vecesSedes;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public void setVecesSedes(int vecesSedes) {
        this.vecesSedes = vecesSedes;
    }
}
