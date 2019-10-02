package com.example.demo.entities.Mysql;

import javax.persistence.*;

@Entity
@Table(name = "Sede_jjoo")
public class SedeJJOO {

    @EmbeddedId
    private SedeJJOOPK sedeJJOOPK;

    @ManyToOne
    @JoinColumn(name="sede")
    private Ciudad ciudadSede;

    public SedeJJOO(SedeJJOOPK sedeJJOOPK, Ciudad ciudadSede) {
        this.sedeJJOOPK = sedeJJOOPK;
        this.ciudadSede = ciudadSede;
    }

    public SedeJJOO() {
    }

    public SedeJJOOPK getSedeJJOOPK() {
        return sedeJJOOPK;
    }

    public Ciudad getCiudadSede() {
        return ciudadSede;
    }

    public void setSedeJJOOPK(SedeJJOOPK sedeJJOOPK) {
        this.sedeJJOOPK = sedeJJOOPK;
    }

    public void setCiudadSede(Ciudad ciudadSede) {
        this.ciudadSede = ciudadSede;
    }
}
