package com.dambi.mongo_restapi;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "balorazioa")
public class Balorazioa {
    @Id
    private ObjectId _id;
    private String erabiltzailea;
    private String testua;
    private int kopurua;
    private Date data;

    //ID
    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
    //ERABILTZAILEA
    public String getErabiltzailea() {
        return erabiltzailea;
    }

    public void setErabiltzailea(String erabiltzailea) {
        this.erabiltzailea = erabiltzailea;
    }
    //TESTUA
    public String getTestua() {
        return testua;
    }

    public void setTestua(String izena) {
        this.testua = izena;
    }
    //KOPURUA
    public int getKopurua() {
        return kopurua;
    }

    public void setKopurua(int kopurua) {
        this.kopurua = kopurua;
    }
    //DATA
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
