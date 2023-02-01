package com.dambi.mongo_restapi;

import java.sql.Timestamp;

public class Partida {
    private Integer id;
    private String user;
    private int puntuazioa;
    private Timestamp data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String name) {
        this.user = name;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public String getData() {
        return data.toString();
    }
 
    public void setData(Timestamp data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Partida[id: " + id +
                ", user: " + user +
                ", puntuazioa: " + puntuazioa +
                ", data: " + data.toString();
    }

}