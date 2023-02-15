package com.dambi.mongo_restapi.pojoak;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@Document(collection = "partida")
@JsonIgnoreProperties("_class")
public class Partida {
    // @Id
    // private ObjectId _id;
    private Integer partidaId;
    private String langilea;
    private int puntuazioa, taldea;
    private Date data;
    private String jokoa;

    // ID
    // public ObjectId get_id() {
    // return _id;
    // }

    // public void set_id(ObjectId _id) {
    // this._id = _id;
    // }
    // PARTIDA
    public Integer getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Integer id) {
        this.partidaId = id;
    }

    // LANGILEA
    public String getLangilea() {
        return langilea;
    }

    public void setLangilea(String user) {
        this.langilea = user;
    }

    // PUNTUAZIOA
    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    // DATA
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    // JOKOA
    public String getJokoa() {
        return jokoa;
    }

    public void setJokoa(String jokoa) {
        this.jokoa = jokoa;
    }

    // Taldea
    public int getTaldea() {
        return taldea;
    }

    public void setTalda(int taldea) {
        this.taldea = taldea;
    }

}
