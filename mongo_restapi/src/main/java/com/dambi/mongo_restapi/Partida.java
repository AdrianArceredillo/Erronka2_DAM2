package com.dambi.mongo_restapi;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "partida")
public class Partida {
    @Id
    private ObjectId _id;
    private Integer partidaId;
    private String langilea;
    private int puntuazioa;
    // private String data;
    // private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    
    // Getters and setters for each field
    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Integer getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Integer id) {
        this.partidaId = id;
    }

    public String getLangilea() {
        return langilea;
    }

    public void setLangilea(String user) {
        this.langilea = user;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }


    // public Date getData() {
    //     try {
    //         return dateFormat.parse(data);
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

    // public void setData(Date data) {
    //     this.data = dateFormat.format(data);
    // }
}
