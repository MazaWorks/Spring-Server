package com.example.demo.entities.Mongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "GET")
public class GET {
    @Id
    public ObjectId ID;

    public String HORA;
    public List DEVUELTO;
    public String STATUS;

    public GET(ObjectId ID, String HORA, List DEVUELTO, String STATUS) {
        this.ID = ID;
        this.HORA = HORA;
        this.DEVUELTO = DEVUELTO;
        this.STATUS = STATUS;
    }

    public ObjectId getID() {
        return ID;
    }

    public void setID(ObjectId ID) {
        this.ID = ID;
    }

    public String getHORA() {
        return HORA;
    }

    public void setHORA(String HORA) {
        this.HORA = HORA;
    }

    public List getDEVUELTO() {
        return DEVUELTO;
    }

    public void setDEVUELTO(List DEVUELTO) {
        this.DEVUELTO = DEVUELTO;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
