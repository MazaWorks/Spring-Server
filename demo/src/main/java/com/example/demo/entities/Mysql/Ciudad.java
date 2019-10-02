package com.example.demo.entities.Mysql;

import javax.persistence.*;

@Entity
@Table(name = "Ciudad")
public class Ciudad {

    @Id
    @Column(name = "id_ciudad")
    private Integer idCiudad;

    @Column(name = "valor_ciudad")
    private Integer valorCiudad;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public Ciudad(Integer idCiudad, Integer valorCiudad, String nombreCiudad, Pais pais) {
        this.idCiudad = idCiudad;
        this.valorCiudad = valorCiudad;
        this.nombreCiudad = nombreCiudad;
        this.pais = pais;
    }

    public Ciudad() {
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

    public Pais getPais() {
        return pais;
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

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
