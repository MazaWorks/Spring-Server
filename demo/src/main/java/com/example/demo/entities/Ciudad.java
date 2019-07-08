package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ciudad")
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

    @OneToMany(targetEntity = SedeJJOO.class, mappedBy = "ciudadSede")
    private List<SedeJJOO> sedesJJOO;

    public Ciudad(Integer idCiudad, Integer valorCiudad, String nombreCiudad, Pais pais, List<SedeJJOO> sedesJJOO) {
        this.idCiudad = idCiudad;
        this.valorCiudad = valorCiudad;
        this.nombreCiudad = nombreCiudad;
        this.pais = pais;
        this.sedesJJOO = sedesJJOO;
    }

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

    public List<SedeJJOO> getSedesJJOO() {
        return sedesJJOO;
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

    public void setSedesJJOO(List<SedeJJOO> sedesJJOO) {
        this.sedesJJOO = sedesJJOO;
    }
}
