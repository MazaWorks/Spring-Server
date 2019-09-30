package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "Tipo_jjoo")
public class TipoJJOO {

    @Id
    @Column(name = "id_tipo_jjoo")
    private Integer idTipoJJOO;

    @Column(name = "descripcion_tipo")
    private String descripcionTipo;

    public TipoJJOO(int idTipoJJOO, String descripcionTipo) {
        this.idTipoJJOO = idTipoJJOO;
        this.descripcionTipo = descripcionTipo;
    }

    public TipoJJOO() {
    }

    public int getIdTipoJJOO() {
        return idTipoJJOO;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setIdTipoJJOO(int idTipoJJOO) {
        this.idTipoJJOO = idTipoJJOO;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }
}
