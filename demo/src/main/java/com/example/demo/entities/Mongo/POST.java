package com.example.demo.entities.Mongo;

import com.example.demo.dtos.PostedDto;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "POST")
public class POST {
    @Id
    public ObjectId ID;

    public String HORA;
    public PostedDto POSTED;
    public String STATUS;

    public POST(ObjectId ID, String HORA, PostedDto POSTED, String STATUS) {
        this.ID = ID;
        this.HORA = HORA;
        this.POSTED = POSTED;
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

    public PostedDto getPOSTED() {
        return POSTED;
    }

    public void setPOSTED(PostedDto POSTED) {
        this.POSTED = POSTED;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
