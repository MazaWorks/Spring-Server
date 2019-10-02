package com.example.demo.entities.Mongo;

import com.example.demo.dtos.IdsDtos;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DELETE")
public class DELETE {
    @Id
    public ObjectId ID;

    public String HORA;
    public IdsDtos Id_jjoo;
    public String STATUS;

    public DELETE(ObjectId ID, String HORA, IdsDtos id_jjoo, String STATUS) {
        this.ID = ID;
        this.HORA = HORA;
        Id_jjoo = id_jjoo;
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

    public IdsDtos getId_Tipo_jjoo() {
        return Id_jjoo;
    }

    public void setId_Tipo_jjoo(IdsDtos id_Tipo_jjoo) {
        Id_jjoo = id_Tipo_jjoo;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
