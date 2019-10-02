package com.example.demo.entities.Mysql;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SedeJJOOPK implements Serializable {

    @Column(name = "año")
    private Integer año;

    @ManyToOne
    @JoinColumn(name="id_tipo_jjoo")
    private TipoJJOO tipoJJOO;

    public SedeJJOOPK(Integer año, TipoJJOO tipoJJOO) {
        this.año = año;
        this.tipoJJOO = tipoJJOO;
    }

    public SedeJJOOPK() {
    }

    public Integer getAño() {
        return año;
    }

    public TipoJJOO getTipoJJOO() {
        return tipoJJOO;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public void setTipoJJOO(TipoJJOO tipoJJOO) {
        this.tipoJJOO = tipoJJOO;
    }
}