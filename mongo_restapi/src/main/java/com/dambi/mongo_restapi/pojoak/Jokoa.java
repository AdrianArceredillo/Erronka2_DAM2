package com.dambi.mongo_restapi.pojoak;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "jokoa")
public class Jokoa {
    //@Id
    private String jokoa;
    private int taldea;

    public String getJokoa() {
        return jokoa;
    }

    public void setJokoa(String jokoa) {
        this.jokoa = jokoa;
    }
    //TALDEA
    public int getTaldea() {
        return taldea;
    }

    public void setTaldea(int puntuazioa) {
        this.taldea = puntuazioa;
    }
}
