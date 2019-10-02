package com.example.demo.dtos;

public class IdsDtos {

    private Integer id_ciudad;
    private Integer id_jjoo_sede;
    private Integer jjoo_tipo;

    public IdsDtos(Integer id_ciudad, Integer id_jjoo_sede, Integer jjoo_tipo) {
        this.id_ciudad = id_ciudad;
        this.id_jjoo_sede = id_jjoo_sede;
        this.jjoo_tipo = jjoo_tipo;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public Integer getId_jjoo_sede() {
        return id_jjoo_sede;
    }

    public void setId_jjoo_sede(Integer id_jjoo_sede) {
        this.id_jjoo_sede = id_jjoo_sede;
    }

    public Integer getJjoo_tipo() {
        return jjoo_tipo;
    }

    public void setJjoo_tipo(Integer jjoo_tipo) {
        this.jjoo_tipo = jjoo_tipo;
    }
}
