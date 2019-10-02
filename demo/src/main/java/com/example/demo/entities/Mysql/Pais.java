package com.example.demo.entities.Mysql;

import javax.persistence.*;

@Entity
@Table(name = "Pais")
public class Pais {
    @Id
    @Column(name = "id_pais")
    private Integer idPais;

    @Column(name = "valor_pais")
    private Integer valorPais;

    @Column(name = "nombre_pais")
    private String nombrePais;

    @Column(name = "codigo_pais")
    private String codigoPais;

    public Pais(Integer idPais, String nombrePais, String codigoPais, Integer valorPais) {
        this.idPais = idPais;
        this.valorPais = valorPais;
        this.nombrePais = nombrePais;
        this.codigoPais = codigoPais;
    }

    public Pais() {
    }

    public Integer getIdPais() {
        return idPais;
    }

    public Integer getValorPais() {
        return valorPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public void setValorPais(Integer valorPais) {
        this.valorPais = valorPais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

}