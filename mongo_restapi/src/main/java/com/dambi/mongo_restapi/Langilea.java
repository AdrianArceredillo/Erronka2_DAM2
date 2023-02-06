package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "langilea")
public class Langilea {
    @Id
    private ObjectId _id;
    private String email;
    private String izena;
    private String user;
    // private Date jaiotzadata;
    private int taldea;
    // private String data;
    // private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd
    // HH:mm:ss.S");

    // Getters and setters for each field
    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getEmail() {
        return email;
    }

    public void setPartidaId(String email) {
        this.email = email;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTaldea() {
        return taldea;
    }

    public void setTaldea(int puntuazioa) {
        this.taldea = puntuazioa;
    }

    // public Date getData() {
    // try {
    // return dateFormat.parse(data);
    // } catch (Exception e) {
    // return null;
    // }
    // }

    // public void setData(Date data) {
    // this.data = dateFormat.format(data);
    // }
}
