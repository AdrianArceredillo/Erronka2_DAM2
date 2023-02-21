package com.dambi.mongo_restapi.pojoak;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "langilea")
public class Langilea {
    // @Id
    // private ObjectId _id;
    private String email;
    private String izena;
    private String user;
    private Date jaiotzadata;
    private int taldea;
    // private String data;
    // private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd
    // HH:mm:ss.S");

    // ID
    // public ObjectId get_id() {
    //     return _id;
    // }

    // public void set_id(ObjectId _id) {
    //     this._id = _id;
    // }
    //EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //IZENA
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }
    //USER
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    //TALDEA
    public int getTaldea() {
        return taldea;
    }

    public void setTaldea(int puntuazioa) {
        this.taldea = puntuazioa;
    }
    //DATA
    public Date getJaiotzadata() {
        return jaiotzadata;
    }

    public void setJaiotzadata(Date jaiotzadata) {
        this.jaiotzadata = jaiotzadata;
    }
}
