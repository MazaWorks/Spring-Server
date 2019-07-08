package com.example.demo.daos.mongo;

import com.example.demo.dtos.FullDtos.SedeJJOOFullDtos;
import com.example.demo.dtos.SedeJJOODtos;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.orderBy;

public class DAOPosts {

    private String user = "usuario"; // the user name
    private String database = "admin"; // the name of the database in which the user is defined
    private char[] password = "password".toCharArray(); // the password as a character array

    private MongoCredential credential = MongoCredential.createCredential(user, database, password);
    private MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
    private MongoDatabase dbs = mongo.getDatabase("log");

    public void create(SedeJJOODtos newPost, String status) {
        Gson gson = new Gson();
        String jsonDevuelto = gson.toJson(newPost);

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        Document doc = new Document();
        doc.append("_id", findIdentifier());
        doc.append("HORA", hourdateFormat.format(date));
        doc.append("POST", JSON.parse(jsonDevuelto));
        doc.append("STATUS", status);

        dbs.getCollection("POST").insertOne(doc);
    }

    private Integer findIdentifier() {
        Integer id = null;
        MongoCursor<Document> iterator = dbs.getCollection("POST").find().sort(orderBy(ascending("_id"))).iterator();
        if (!iterator.hasNext()){
            id = 1;
        } else {
            while(iterator.hasNext()){
                Document document = iterator.next();
                JSONObject json = new JSONObject(document.toJson());
                id = json.getInt("_id") + 1;
            }
        }
        return id;
    }

    public void create(SedeJJOOFullDtos newPost, String status) {
        Gson gson = new Gson();
        String jsonDevuelto = gson.toJson(newPost);

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        Document doc = new Document();
        doc.append("_id", findIdentifier());
        doc.append("HORA", hourdateFormat.format(date));
        doc.append("POST", JSON.parse(jsonDevuelto));
        doc.append("STATUS", status);

        MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
        MongoDatabase dbs = mongo.getDatabase("log");
        dbs.getCollection("POST").insertOne(doc);
    }

    public void create(String status) {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        Document doc = new Document();
        doc.append("_id", findIdentifier());
        doc.append("HORA", hourdateFormat.format(date));
        doc.append("STATUS", status);

        MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
        MongoDatabase dbs = mongo.getDatabase("log");
        dbs.getCollection("POST").insertOne(doc);
    }
}
