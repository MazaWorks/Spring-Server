package com.example.demo.daos.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Sorts.orderBy;

public class DAODelete {

    private String user = "usuario"; // the user name
    private String database = "admin"; // the name of the database in which the user is defined
    private char[] password = "password".toCharArray(); // the password as a character array

    private MongoCredential credential = MongoCredential.createCredential(user, database, password);
    private MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
    private MongoDatabase dbs = mongo.getDatabase("log");

    public void create(Integer id, Integer idTipoJJOO, String status) {
        JSONObject jsonDevuelto = new JSONObject();
        jsonDevuelto.put("id", id);
        jsonDevuelto.put("idTipoJJOO", idTipoJJOO);

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        Document doc = new Document();
        doc.append("_id", findIdentifier());
        doc.append("HORA", hourdateFormat.format(date));
        doc.append("ID DELETE", jsonDevuelto.toString());
        doc.append("STATUS", status);

        dbs.getCollection("DELETE").insertOne(doc);
    }

    private Integer findIdentifier() {
        Integer id = null;
        MongoCursor<Document> iterator = dbs.getCollection("DELETE").find().sort(orderBy(ascending("_id"))).iterator();
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

    public void create(Integer id, String status) {
        JSONObject jsonDevuelto = new JSONObject();
        jsonDevuelto.put("id", id);

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        Document doc = new Document();
        doc.append("_id", findIdentifier());
        doc.append("HORA", hourdateFormat.format(date));
        doc.append("ID DELETE", jsonDevuelto.toString());
        doc.append("STATUS", status);

        MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
        MongoDatabase dbs = mongo.getDatabase("log");
        dbs.getCollection("DELETE").insertOne(doc);
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
        dbs.getCollection("DELETE").insertOne(doc);
    }
}
